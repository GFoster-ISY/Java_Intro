package P03_Data;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class C10_Group_P2 {
    // Modify the code so that the numbers are read directly into the bin array rather than into the data array.
    // Delete the data array completely.
    public static void main(String[] args) throws IOException {
        String file = "resources/01_Data";
        Scanner scanner = new Scanner(new File(file));
        scanner.useDelimiter(",");
        int size = Integer.parseInt(scanner.nextLine());
        int[] bin = new int[10];
        int data;
        while (scanner.hasNext()) {
            data = Integer.parseInt(scanner.next());
            int tens = data / 10;
            if (tens < 10) {
                bin[tens]++;
            } else {
                System.err.println(data + " is larger than expected");
            }
        }
        scanner.close();

        for (int i = 0; i < 10; i++) {
            System.out.println(i + ": " + bin[i]);
        }
    }

} // end of class C10_Group_P2
