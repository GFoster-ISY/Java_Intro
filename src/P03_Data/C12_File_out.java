package P03_Data;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class C12_File_out {
    public static void main(String[] args) throws IOException {
        final int SIZE = 200;
        final int MEAN = 55;
        final int STDEV = 25;
        String file = "resources/02_Data";
        FileWriter writer = new FileWriter(file);

        int[] data = new int[SIZE];
        Random rand = new Random();
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            // Get a number between 0 and 100 inclusive
            // normally distributed with a mean of MEAN
            // and a standard deviation of STDEV
            data[i] = (int) ((rand.nextGaussian() * STDEV) + MEAN);
            if (data[i] > 100) data[i] = 100;
            if (data[i] < 0) data[i] = 0;
        }
        for (int i = 0; i < SIZE; i++) {
            writer.write(""+data[i]);
            if (i<SIZE-1){
                writer.write(",");
            }
            System.out.print(data[i] + " ");
        }
        writer.close();
    }
}
