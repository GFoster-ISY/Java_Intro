package P03_Data;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class C10_Group {
    public static void main(String[] args) throws IOException {
        String file = "resources/01_Data";
        Scanner scanner = new Scanner(new File(file));
        scanner.useDelimiter(",");
        int size = Integer.parseInt(scanner.nextLine());
        int[] data = new int[size];
        int count = 0;
        while (scanner.hasNext()) {
            data[count] = Integer.parseInt(scanner.next());
            count++;
        }
        scanner.close();

        int[] bin = new int[10];
        for (int i = 0; i < size; i++) {
            int tens = data[i] / 10;
            if (tens < 10) {
                bin[tens]++;
            } else {
                System.err.println(data[i] + " is larger than expected");
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ": " + bin[i]);
        }
    }
} // end of class C10_Group
