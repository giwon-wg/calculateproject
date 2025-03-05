import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {

        //Calculator 호출
        Calculator<Number> calculator = new Calculator();

        //Scanner 활성화
        Scanner sc = new Scanner(System.in);

        System.out.print("\n개선 버전 사용 여부( y / n )\n: ");
        char yesNo;
        while (true){
            yesNo = sc.next().charAt(0);
            sc.nextLine(); //입력 버퍼
            if(yesNo == 'y' || yesNo =='n'){
                break;
            }
            System.out.println("잘못된 값을 입력하였습니다.");
        }

        //무한 반복을 위한 for 문
        for (int i = 1; ; i++) {
            System.out.printf("\n========계산 준비 완료 / 사용량 : %d회==========\n\n", i-1);
            Number fstVal, sndVal;
            OperatorType operatortype;

            //연산을 위한 값 입력받기
            if(yesNo == 'y'){
                String[] parsed;
                while(true){
                    System.out.println("수식을 입력하세요");
                    System.out.println("ex) a (+, -, *, /) b");
                    System.out.print("ex) sqrt(a)\n: ");
                    String input = sc.nextLine();
                    parsed = parseExpression(input);
                    if(parsed != null){
                        break;
                    } // 오타 예외 처리
                    System.out.println("잘못된 값을 입력하였습니다.");
                }

                if(parsed[0].equals("sqrt")){
                    fstVal = getdata(parsed[1]);
                    operatortype = OperatorType.sqrt;
                    sndVal = null;
                } else {
                    fstVal = getdata(parsed[0]);
                    operatortype = OperatorType.getOperatorType(parsed[1].charAt(0));
                    sndVal = getdata(parsed[2]);
                }
            } else {
                fstVal = getdata(getnum(sc, "첫번째 숫자를 입력하세요."));
                System.out.println();
                operatortype = getdatasymol(sc, "사칙연산 기호를 입렵하세요(+, -, *, /)");
                sndVal = getdata(getnum(sc, "두번째 숫자를 입력하세요."));
                System.out.println();
            }



            //연산 처리(Calculator.java)
            double result = calculator.calculate(fstVal, sndVal, operatortype);

            //계산값 출력
            List<String> calculatedValue = calculator.getHistory(); // 계산 기록 가져오기
            System.out.println("계산값: ");
            if (!calculatedValue.isEmpty()) { // 리스트가 비어있지 않다면
                System.out.println(calculatedValue.get(calculatedValue.size() - 1)); // 마지막(최근) 연산 출력
            }
            System.out.println();

            //getter 를 사용해 데이터 받기 and 최근 계산값 10개 출력
            System.out.println("최근 계산값");
            for (String history : calculator.getHistory()) {
                System.out.println(history);
            }
            System.out.println();

            // 도전 입력값보다 큰값 찾기
            System.out.print("입력값 보다 큰 값을 출력할까요 ( y / n )\n: ");
            char yn = sc.next().charAt(0);
            if(yn == 'y'){
                Number Value2 =  getdata(getnum(sc, "\n값을 입력 하세요"));
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
            System.out.print("종료 하시려면 'exit'를 입력해주세요\n: ");
            String out = sc.next();
            sc.nextLine(); //입력 버퍼
            if (Objects.equals(out, "exit")){
                break;
            }
        }
        //Scanner 비활성화
        sc.close();
    }

    //정수 입력 받기 메서드
    private static String getnum(Scanner sc, String msg){
        System.out.println(msg);
        System.out.print(": ");
        return sc.next();
    }

    //제네릭 활용 데이터 타입 변환
    private static <T extends Number> T getdata(String input) {
        try{
            if(input.contains(".")){
                return (T) Double.valueOf(input);
            } else {
                return (T) Integer.valueOf(input);
            }
        } catch (NumberFormatException e){ // 오타 예외 처리
            System.out.println("잘못된 값을 입력하였습니다.");
            System.out.print(": ");
            return null;
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

    //개선된 계산기
    public static String[] parseExpression(String input){
        input = input.replace(" ",""); // 공백 제거

        if(input.startsWith("sqrt(") && input.endsWith(")")){
            return new String[]{"sqrt", input.substring(5, input.length() - 1)};
        }

        Pattern pattern = Pattern.compile("(\\d+(?:\\.\\d+)?)([+\\-*/])(\\d+(?:\\.\\d+)?)"); //정규 표현식(소수점 허용)
        Matcher matcher = pattern.matcher(input);

        if(matcher.matches()){
            return new String[]{matcher.group(1), matcher.group(2), matcher.group(3)};
        } else{
            return null;
        }
    }

    //정수 입력받기 매서드 // 제네릭 활용 데이터 타입 변환
//    private static <T extends Number> T getdataval(Scanner sc, String msg){
//        System.out.println(msg);
//        System.out.print(": ");
//
//        while (true){
//            String input = sc.next();
//            try{
//                if(input.contains(".")){
//                    return (T) Double.valueOf(input);
//                } else {
//                    return (T) Integer.valueOf(input);
//                }
//            } catch (NumberFormatException e){ // 오타 예외 처리
//                System.out.println("잘못된 값을 입력하였습니다.");
//                System.out.print(": ");
//            }
//        }
//    }
}