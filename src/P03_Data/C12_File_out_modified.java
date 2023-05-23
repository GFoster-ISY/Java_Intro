package P03_Data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class C12_File_out_modified {
    final static int SIZE = 200;
    final static int MEAN = 55;
    final static int STDEV = 25;
    public static void main(String[] args) {
        String file = getNextFileName();
        int[] data = generateData();
        writeFile(data, file);
    }

    public static int[] generateData(){
        Random rand = new Random();
        int[] data = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            // Get a number between 0 and 100 inclusive
            // normally distributed with a mean of MEAN
            // and a standard deviation of STDEV
            data[i] = (int) ((rand.nextGaussian() * STDEV) + MEAN);
            if (data[i] > 100) data[i] = 100;
            if (data[i] < 0) data[i] = 0;
        }
        return data;
    }

    public static void writeFile(int[] data, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);

            for (int i = 0; i < SIZE; i++) {
                writer.write("" + data[i]);
                if (i < SIZE - 1) {
                    writer.write(",");
                }
                System.out.print(data[i] + " ");
            }
            writer.close();
        } catch (IOException e){
            System.out.println(fileName + " is a directory and cannot be written to.");
        }
    } // end of method writeFile

    private static String getNextFileName(){
        int fileNumber = 0;
        File file;
        do {
            fileNumber++;
            String filename = String.format(System.getProperty("user.dir")+"/resources/%02d_Data",fileNumber);
            file = new File(filename);
        }while (file.exists());
        return file.getPath();
    }
    private static String getNextAvailableFileName(){
        String userDirectoryName = System.getProperty("user.dir")+"/resources";
        File userDirectory = new File(userDirectoryName);
        int largestNumber = 1;
        for (final File fileEntry : userDirectory.listFiles()) {
            String prefix = fileEntry.getName().substring(0,2);
            try {
                int num = Integer.parseInt(prefix);
                if (num > largestNumber) {
                    largestNumber = num;
                }
            } catch (NumberFormatException e){
                // Do nothing
            }
        }
        return String.format("resources/%02d_Data",largestNumber+1);
    }// end of method getNextAvailableFileName

}
