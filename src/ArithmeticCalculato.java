public class ArithmeticCalculato {

    public static int add(int a, int b){

        return a + b;
    }

    public static int sub(int a, int b) {
        return a - b;
    }

    public static int mul(int a, int b){
        return a * b;
    }

    public static double div(int a, int b){
        if (b == 0){
            throw new Error("분모에는 0이 들어갈 수 없습니다");
        }
        return (double) a / b;
    }
}
