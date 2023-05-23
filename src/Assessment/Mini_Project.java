package Assessment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Mini_Project {
    static int[][] data;
    static int width = 10;
    static int height = 5;
    static Scanner keyboard;
    static Random rand = new Random();
    static int change = 1;
    public static void main(String[] args){
        keyboard = new Scanner(System.in);
        data = new int[height][width];
        boolean finished;
        do {
            display();
            playerTurn();
            computerTurn();
            finished = score();
        }while(!finished);
    } // end of main method
    private static void playerTurn(){
        change = 1;
        System.out.print("Please enter your move:");
        String move = keyboard.nextLine();
        try {
            // The turn is entered using a letter number coordinate such as F3
            int x = Character.toUpperCase(move.charAt(0))-'A'; // convert to a zero indexed number
            int y = Integer.parseInt(move.substring(1,2))-1;
            data[y][x]+=change;
            flood(x,y);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid move, please try again.");
            playerTurn();
        }
    } // end of method playerTurn
    private static void computerTurn(){
        change = -1;
        // Find a point which has a value equal to -1
        int totalPositions = width*height;
        // slide is used to start searching at a random location
        int slide = rand.nextInt(totalPositions);
        for (int i = 0; i< width; i++) {
            for (int j = 0; j < height; j++) {
                int index = (i+ j*width + slide)%(totalPositions);
                int x = index % width;
                int y = index / width;
                if (data[y][x] == change) {
                    data[y][x] += change;
                    flood(x,y);
                    return;
                }
            }
        }
        // Random point clustered in the centre
        try {
            int x = (int)(rand.nextGaussian()*(width/5.0)+width/2.0);
            int y = (int)(rand.nextGaussian()*(height/5.0)+height/2.0);
            data[y][x] += change;
            flood(x, y);
        } catch (ArrayIndexOutOfBoundsException e){
            computerTurn();
        }
    } // end of method computerTurn
    static private boolean score(){
        int playerScore = 0;
        int computerScore = 0;
        final int TARGET = height * width / 2;
        for (int[] row : data) {
            for (int cell : row) {
                if (cell < 0) computerScore++;
                else if (cell > 0) playerScore++;
            }
        }
        System.out.println("Player score " + playerScore);
        System.out.println("Computer score " + computerScore);
        if (playerScore > TARGET){
            System.out.println("Congratulations You won, with a score of ("+(playerScore - computerScore)+").");
            highscore(playerScore - computerScore);
            return true;
        } else if (computerScore > TARGET){
            System.out.println("Sorry, but you lost.");
            return true;
        }
        return false;
    } // end of method score
    private static void highscore(int score){
        String filename = "resources/highscore.mp";
        int hiscore = 0;
        try {
            Scanner highscoreFile = new Scanner(new File(filename));
            hiscore = highscoreFile.nextInt();
        } catch (FileNotFoundException e) {
            // no highscore recorded
        }
        if (score > hiscore){
            System.out.println("Congratulations this is a new high score");
            try {
                FileWriter fw = new FileWriter(filename);
                fw.write(""+score);
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("You didn't beat the old high score of " + hiscore);
        }
    } // end of method highscore
    private static void flood(int x, int y){
        if (data[y][x]*change <= 1){ return; }
        try {
            data[y-1][x]+=change;
        }catch (ArrayIndexOutOfBoundsException e){
            // on the boundary so ignore
        }
        try {
            data[y][x-1]+=change;
        }catch (ArrayIndexOutOfBoundsException e){
            // on the boundary so ignore
        }
        try {
            data[y+1][x]+=change;
        }catch (ArrayIndexOutOfBoundsException e){
            // on the boundary so ignore
        }
        try {
            data[y][x+1]+=change;
        }catch (ArrayIndexOutOfBoundsException e){
            // on the boundary so ignore
        }
    } // end of method flood
    private static void display(){
        int rowCount = 0;
        char c = 'A';
        System.out.print("   ");
        for (int i = 0; i< width; i++){
            System.out.print(" "+(c++)+" ");
        }
        System.out.println();
        for (int[] row : data){
            System.out.print((++rowCount) + " |");
            for (int cell: row){
                if (cell == 0){
                    System.out.print(" · ");
                } else if (cell < 0){
                    System.out.print(" x ");
                } else {
                    if (cell > 9){
                        System.out.print(cell + " ");
                    } else {
                        System.out.print(" " + cell + " ");
                    }
                }
            } // end of loop through each value (in a given row)
            System.out.println();
        } // end of loop through each data row
    } // end of method display
} // end of class mini project
