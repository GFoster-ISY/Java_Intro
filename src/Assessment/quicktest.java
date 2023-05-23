package Assessment;


import java.util.HashSet;
        import java.util.LinkedList;
        import java.util.Stack;

public class quicktest {
    public static void main(String[] args) {
        SumBalancedBrackets.main(args);
    }
}

class SumBalancedBrackets {
    private static LinkedList<TestCase> tc = new LinkedList<TestCase>();
    public static void main(String[] args){
        tc.push(new TestCase("()", true));
        tc.push(new TestCase("(]", false));
        tc.push(new TestCase("{()}[ ]", true));
        tc.push(new TestCase("}{", false));
        tc.push(new TestCase("{[<>]}", true));
        tc.push(new TestCase("}{><][", false));
        tc.push(new TestCase(")(}{][", false));
        tc.push(new TestCase("{}", true));
        tc.push(new TestCase("<>", true));
        tc.push(new TestCase("[]", true));

        System.out.println(tc);
        while(!tc.isEmpty()){
            TestCase testingCase = tc.pop();
            testingCase.runTest();
        }
    }

}
class TestCase {
    static int testRun;
    static int testFailed;
    CheckBrackets data;
    boolean expected;

    public TestCase(String data, boolean expected) {
        this.data = new CheckBrackets(data);
        this.expected = expected;
    }

    public void runTest() {
        boolean result = data.runCheck();
        testRun ++;
        if (result != expected){
            testFailed++;
            System.out.println(this);
        }
    }
    public String toString (){
        return data + " is expected to be " + expected;
    }
}
class CheckBrackets{
    String data;
    static HashSet<String> open = new HashSet<>();
    static HashSet<String> pair = new HashSet<>();

    public static void init () {
        if (open.isEmpty()) {
            open.add("(");
            open.add("[");
            open.add("<");
            open.add("{");
        }
        if (pair.isEmpty()) {
            pair.add("()");
            pair.add("<>");
            pair.add("{}");
            pair.add("[]");
        }
    }// added
//        public boolean runCheck(){
//            System.out.println(data);
//            Stack<String> stack = new Stack<>();
//            for (int i = 0; i < data.length(); i++) {
//                String bracket = data.substring(i, i+1);
//                if (open.contains(bracket)) { // changed from single
//                    stack.push(bracket);
//                }else{
//                    if (stack.isEmpty()) {
//                        return false;
//                    }
//                    String lastBRacket = stack.pop();
//                    if (!pair.contains(lastBRacket + bracket)) {
//                        return false;
//                    }
//                }
//            }return true;
//        }
        CheckBrackets(String data){
            this.data = data;
            init();
        }
        boolean runCheck(){
            Stack<String> check = new Stack<>();
            for(int i = 0; i < data.length(); i++){
                String bracket = data.substring(i, i+1);

                if(open.contains(bracket)){
                    check.push(bracket);
                } else {
                    if(check.empty()){
                        return false;
                    }
                    String open = check.pop();
                    String balBracket = open + bracket;
                    if (pair.contains(balBracket)){
                        //continue
                    }else{
                        return false;
                    }
                }
            }
            if(check.empty()){
                return true;
            }else{
                return false;
            }

        }

    public String toString(){
        return data;


    }
    public CheckBrackets(){

        init();
    }
}

