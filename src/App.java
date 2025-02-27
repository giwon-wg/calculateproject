import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        //Calculator 호출
        Calculator<Number> calculator = new Calculator();

        //Scanner 활성화
        Scanner sc = new Scanner(System.in);

        //무한 반복을 위한 for 문
        for (int i = 1; ; i++) {
            System.out.printf("\n========계산 준비 완료 / 사용량 : %d회==========\n\n", i-1);

            //연산을 위한 값 입력받기
            Number fstVal = getdataval(sc, "첫번째 숫자를 입력하세요.");
            System.out.println();
            OperatorType operatortype = getdatasymol(sc, "사칙연산 기호를 입렵하세요(+, -, *, /)");
            Number sndVal = getdataval(sc, "두번째 숫자를 입력하세요.");
            System.out.println();

            //연산 처리(Calculator.java)
            double result = calculator.calculate(fstVal, sndVal, operatortype);
            System.out.printf("결과값 :\n%s %c %s = %s\n\n", fstVal, operatortype.getSymbol(), sndVal, result);


            //getter 를 사용해 데이터 받기
            System.out.println("최근 계산값");
            for (String history : calculator.getHistory()) {
                System.out.println(history);
            }
            System.out.println();

            // 도전 입력값보다 큰값 찾기
            System.out.println("입력값 보다 큰 값을 출력할까요 ( y / n )");
            char yn = sc.next().charAt(0);
            if(yn == 'y'){
                Number Value2 = getdataval(sc, "\n값을 입력 하세요");
                List<Double> result2 = calculator.filterVal(Value2);

                if(result2.isEmpty()){
                    System.out.println("\n목록");
                    System.out.println("=========");
                    System.out.println();
                    System.out.println("=========");
                } else {
                    System.out.println("\n목록");
                    System.out.println("=========");
                    result2.forEach(System.out::println);
                    System.out.println("=========");
                }
            }

            //종료 문구 확인
            System.out.println("종료 하시려면 'exit'를 입력해주세요: ");
            String out = sc.next();
            if (Objects.equals(out, "exit")){
                break;
            }
        }
        //Scanner 비활성화
        sc.close();
    }

    //정수 입력받기 매서드 // 제네릭 활용 데이터 타입 변환
    private static <T extends Number> T getdataval(Scanner sc, String msg){
        System.out.println(msg);
        System.out.print(": ");

        while (true){
            String input = sc.next();
            try{
                if(input.contains(".")){
                    return (T) Double.valueOf(input);
                } else {
                    return (T) Integer.valueOf(input);
                }
            } catch (NumberFormatException e){
                System.out.println("잘못된 값을 입력하였습니다.");
                System.out.print(": ");
            }
        }
    }

    // 기호 입력받기 매서드
    private static OperatorType getdatasymol(Scanner sc, String msg){
        System.out.println(msg);
        System.out.print(": ");
        while(true){
            String input = sc.next();
            System.out.println();
            if(input.length() == 1){
                char symbol = input.charAt(0);
                try {
                    return OperatorType.getOperatorType(symbol);
                } catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                    System.out.print(": ");
                }
            }
        }
    }
}