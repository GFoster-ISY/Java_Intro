package Numbers;

public class dec_to_bin {
    public static void main(String[] args){
        int num = 43;
        System.out.println(num);
        System.out.println(Integer.toBinaryString(num));
        float pi = 3.141592653590f;
        System.out.println(pi);
        System.out.println(Integer.toBinaryString(Float.floatToIntBits(pi)));
        double pi_d = 3.141592653590;
        System.out.println(pi_d);
        System.out.println(Long.toBinaryString(Double.doubleToLongBits(pi_d)));
    }
}
