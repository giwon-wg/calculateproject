import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int a = 0;
        int b = 0;
        int result = 0;
        String c;

        Scanner sc = new Scanner(System.in);

        for (int i = 1; ; i++) {
            System.out.printf("\n========계산 준비 완료 / 사용량 : %d회==========\n\n", i);
            System.out.println("첫번째 숫자를 입력하세요");
            System.out.print(": ");
            while (!sc.hasNextInt()){
                System.out.println("잘못된 값을 입력하였습니다. 다시 입력해주세요");
                System.out.print(": ");
                sc.next();
            }
            a = sc.nextInt();

            System.out.println("두번째 숫자를 입력하세요");
            System.out.print(": ");
            while (!sc.hasNextInt()){
                System.out.println("잘못된 값을 입력하였습니다. 다시 입력해주세요");
                System.out.print(": ");
                sc.next();
            }
            b = sc.nextInt();

            System.out.println("사칙연산 기호를 입렵하세요(+, -, *, /)");
            System.out.print(": ");
            while(true){
                c = sc.next();
                if(c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")){
                    break;
                } else{
                    System.out.println("잘못된 값을 입력하였습니다. 다시 입력해주세요");
                    System.out.print(": ");
                }
            }



            switch (c) {
                case "+":
                    result = a + b;
                    System.out.println("\n"+ a + c + b + "=" + result + "\n");
                    break;
                case "-":
                    result = a - b;
                    System.out.println("\n"+ a + c + b + "=" + result+ "\n");
                    break;
                case "*":
                    result = a * b;
                    System.out.println("\n"+ a + c + b + "=" + result+ "\n");
                    break;
                case "/":
                    if(b == 0){
                        System.out.println("분모에는 0이 들어갈 수 없습니다."+ "\n");
                        break;
                    }
                    result =  a / b;
                    System.out.println("\n"+ a + c + b + "=" + result);
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