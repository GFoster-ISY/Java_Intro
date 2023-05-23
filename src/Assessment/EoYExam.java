package Assessment;

public class EoYExam {
    public static void main(String[] args) {
        System.out.println(rec_fn(9));
        System.out.println(rec_fn(13));
    }

    static int rec_fn(int num){
        if (num == 0){
            return 1;
        } else {
            return rec_fn(num/2) + num;
        }
    }
}
