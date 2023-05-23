package P03_Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class C13_Graph_Modified {

    static final int COL_COUNT = 11;
    static int [] bins = new int[COL_COUNT];
    static int maxBinSize = 0;
    static final int WIDTH = 5;

    public static void main(String[] args) throws IOException {
        String file = "resources/03_Data";
        getDataFromFile(file);
        displayGraph();
    }

    private static void displayGraph(){
        for (int row = maxBinSize/WIDTH; row>=0; row--){
            for (int col = 0; col < COL_COUNT; col++){
                if (row > bins[col]/WIDTH) {
                    System.out.print("       ");
                } else if (row == bins[col]/WIDTH) {
                    System.out.print(buildBar(bins[col]%WIDTH));
                } else {
                    System.out.print(buildBar(WIDTH));
                }
            }
            System.out.println();
        }

        for (int col = 0; col < COL_COUNT; col++){
            if (col==0) {System.out.print("  ");}
            else if (col<10) {System.out.print(" ");}
            System.out.print((col*10) + "-"+((col+1)*10-1));
            if (col==0) {System.out.print("  ");}
            else if (col<10) {System.out.print(" ");}
        }
        System.out.println();
        for (int col = 0; col < COL_COUNT; col++){
            displayTotal(col);
        }
        System.out.println();

    }

    private static String buildBar(int hash){
        String start = "";
        for (int i = 0; i < (7-hash)/2; i++){
            start += " ";
        }
        String middle = "";
        for (int i = 0; i < hash; i++){
            middle += "#";
        }

        String end = "";
        for (int i = 0; i < (7-hash)/2+ (7-hash)%2; i++){
            end += " ";
        }
        return start+middle+end;

    }
    private static void displayTotal(int col){
        if (bins[col]/10 == 0){
            System.out.print("  (" + bins[col] + ")  ");
        } else {
            System.out.print("  (" + bins[col] + ") ");
        }

    }
    private static void getDataFromFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        scanner.useDelimiter(",");
        while (scanner.hasNext()){
            int value = scanner.nextInt();
            bins[value/10]++;
            if (bins[value/10]>maxBinSize){
                maxBinSize = bins[value/10];
            }
        }
        scanner.close();
    }
}
