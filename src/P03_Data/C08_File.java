package P03_Data;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class C08_File {
    public static void main(String[] args) throws IOException {
        String file = "resources/01_Data";
        Scanner scanner = new Scanner(new File(file));
        scanner.useDelimiter(",");
        int size = Integer.parseInt(scanner.nextLine());
        System.out.println("Expectation is " + size + " numbers.");
        int count = 0;
        while (scanner.hasNext()){
            count++;
            System.out.print(scanner.next()+" ");
        }
        System.out.println();
        System.out.println(count + " numbers were found");
        scanner.close();
    }
}
