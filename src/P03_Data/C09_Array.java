package P03_Data;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class C09_Array {
    public static void main(String[] args) throws IOException {
        String file = "resources/01_Data";
        Scanner scanner = new Scanner(new File(file));
        scanner.useDelimiter(",");
        int size = Integer.parseInt(scanner.nextLine());
        int [] data = new int[size];
        int count = 0;
        while (scanner.hasNext()){
            data[count] = Integer.parseInt(scanner.next());
            count++;
        }
        scanner.close();
        for (int i = 0; i < size; i++){
            System.out.print(data[i]+ " ");
        }
    }

} // end of class C09_Array
