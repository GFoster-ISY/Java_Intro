package P03_Data;

public class C09A_Array_Practice {
    public static void main (String[] args){
        int[] numbers = new int[20];
        for (int i = 0; i < numbers.length; i++){
            numbers[i] = i+1;
        }
        System.out.println(numbers);
        printNumbers(numbers);
        printIndexAndNumbers(numbers);
        swap(numbers, 5, 7);
        printNumbers(numbers);
        addTo(numbers, 4, 10, 16);
        printNumbers(numbers);
        reverse(numbers, 7,12);
        printNumbers(numbers);
    }

    private static void printNumbers(int[] array){
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    private static void printIndexAndNumbers(int[] array){
        for (int i = 0; i < array.length; i++){
            System.out.print("["+ i +"]" + array[i] + " ");
        }
        System.out.println();
    }
    private static void swap (int[] array, int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
    private static void addTo(int[] array, int amount, int start, int end){
        for (int i = start; i <= end; i++){
            array[i]+=amount;
        }
    }
    private static void reverse(int[] array, int start, int end){
        for (int i = 0; i <= (end - start)/2; i++){
            swap(array, start + i, end - i);
        }
    }
}
