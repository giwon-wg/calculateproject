import java.util.Objects;
import java.util.Scanner;


class Calculator {
    public static int calculate(int a, int b, char c) {
        switch (c) {
            case '+':
                return  a + b;
            case '-':
                return  a - b;
            case '*':
                return  a * b;
            case '/':
                if (b == 0) {
                    System.out.println("분모에는 0이 들어갈 수 없습니다." + "\n");
                    break;
                }
                return  a / b;
        }
        return 0;
    }
}

public class Main {
    public static void main(String[] args) {

        int a;
        int b;
        int result;
        String input;
        char c;

        Scanner sc = new Scanner(System.in);

        for (int i = 1; ; i++) {
            System.out.printf("\n========계산 준비 완료 / 사용량 : %d회==========\n\n", i);
            System.out.println("첫번째 숫자를 입력하세요.");
            System.out.print(": ");
            while (!sc.hasNextInt()){
                System.out.println("잘못된 값을 입력하였습니다.");
                System.out.print(": ");
                sc.next();
            }
            a = sc.nextInt();

            System.out.println("두번째 숫자를 입력하세요.");
            System.out.print(": ");
            while (!sc.hasNextInt()){
                System.out.println("잘못된 값을 입력하였습니다.");
                System.out.print(": ");
                sc.next();
            }
            b = sc.nextInt();

            System.out.println("사칙연산 기호를 입렵하세요(+, -, *, /)");
            System.out.print(": ");
            while(true){
                input = sc.next();
                c = input.charAt(0);
                if(c == '+' || c == '-' || c == '*' || c == '/'){
                    break;
                } else{
                    System.out.println("잘못된 값을 입력하였습니다. 입력값: " + c );
                    System.out.print(": ");
                }
            }

            result = Calculator.calculate(a, b, c);
            System.out.println("\n"+ a + c + b + "=" + result);


            System.out.print("종료 하시려면 'exit'를 입력해주세요: ");
            String out = sc.next();
            if (Objects.equals(out, "exit")){
                break;
            }
        }
    }
}