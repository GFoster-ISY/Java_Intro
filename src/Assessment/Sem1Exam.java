package Assessment;

public class Sem1Exam {
    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        String [] items = {"Cake", "Sandwich", "Biscuit", "Coffee" , "Fried Rice", "Wedges", "Orange Juice"};
        int [] prices = {5500, 5000, 2000, 2500 , 6000, 2500, 3000};

        // create the menu
        String[] menu = new String[items.length];
        for (int i = 0; i < items.length; i++){
            String space = "";
            for (int j = items[i].length(); j < 15; j++){
                space = space + " ";
            }
            menu[i] = items[i]+space+prices[i];
        }

        for (String item : menu)
            System.out.println(item);

        int[][] order = { {0, 1, 0}, {2, 2, 0}, {6, 3, 20} };

        int total = 0;
        for (int i = 0; i < order.length; i++){
            total = total + prices[order[i][0]]*order[i][1]*(100-order[i][2])/100;
            System.out.println(total);
        }

        System.out.println(total);
    }
}
