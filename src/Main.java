import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int a = 0;
        int b = 0;
        double result = 0;
        String c;

        Scanner sc = new Scanner(System.in);

        for (int i = 1; ; i++) {
            System.out.printf("\n=======계산 준비 완료=======\n\n", i);
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

            try {
                switch (c) {
                    case "+":
                        result = ArithmeticCalculato.add(a, b);
                        break;
                    case "-":
                        result = ArithmeticCalculato.sub(a, b);
                        break;
                    case "*":
                        result = ArithmeticCalculato.mul(a, b);
                        break;
                    case "/":
                        result = ArithmeticCalculato.div(a, b);
                        break;
                }
                System.out.println("\n"+ a + c + b + "=" + result+ "\n");
                System.out.println("종료 하시려면 exit를 입력해주세요");
                String out = sc.next();
                if (Objects.equals(out, "exit")){
                    System.out.printf("\n=======계산 종료 / 총 사용량 : %d회=======\n",i);
                    break;
                }
            } catch (Error e) {
                System.out.println(e.getMessage());
            }
        }
    }
}