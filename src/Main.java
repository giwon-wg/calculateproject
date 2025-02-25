import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        for (int i = 0; i<100; i++) {

            Scanner sc = new Scanner(System.in);
            System.out.println("첫번째 숫자를 입력하세요");
            int a = sc.nextInt();
            System.out.println("두번째 숫자를 입력하세요");
            int b = sc.nextInt();
            System.out.println("사칙연산 기호를 입렵하세요(+, -, *, /)");
            String c = sc.next();

            int result = 0;

            switch (c) {
                case "+":
                    result = a + b;
                    System.out.println(a + c + b + "=" + result);
                    break;
                case "-":
                    result = a - b;
                    System.out.println(a + c + b + "=" + result);
                    break;
                case "*":
                    result = a * b;
                    System.out.println(a + c + b + "=" + result);
                    break;
                case "/":
                    if(b == 0){
                        System.out.println("분모에는 0이 들어갈 수 없습니다.");
                        break;
                    }
                    result =  a / b;
                    System.out.println(a + c + b + "=" + result);
                    break;

            }

            System.out.println("종료 하시려면 q를 입력해주세요");
            String out = sc.next();
            if (Objects.equals(out, "q")){
                break;
            }
        }

    }
}