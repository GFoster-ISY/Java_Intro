package P03_Data;

import java.util.Random;

public class C11_Random {
    public static void main(String[] args){
        final int SIZE = 20;
        final int MEAN = 55;
        final int STDEV = 10;
        int [] data = new int[SIZE];
        Random rand = new Random();
        for (int i = 0; i < SIZE; i++){
            // Get a number between 0 and 100 inclusive
            data[i] = rand.nextInt(101);
        }
        for (int i = 0; i < SIZE; i++){
            System.out.print(data[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++){
            // Get a number between 0 and 100 inclusive
            // normally distributed with a mean of MEAN
            // and a standard deviation of STDEV
            data[i] = (int)((rand.nextGaussian()*STDEV)+MEAN);
            if (data[i]>100) data[i]= 100;
            if (data[i]<0) data[i]= 0;
        }
        for (int i = 0; i < SIZE; i++){
            System.out.print(data[i] + " ");
        }

    }
}
