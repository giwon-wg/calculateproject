import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator<T extends Number> {
    private List<String> history; //정보 은닉
    private static final int maxSize = 10;


    public Calculator() {
        this.history = new ArrayList<>();
    }

    //연산
    public double calculate(T fstVal, T sndVal, OperatorType operator) {
        double result = 0;
        String savedata;

        double fstValDouble = fstVal.doubleValue();
        double sndValDouble = sndVal.doubleValue();

        switch (operator) {
            case add:
                result = fstValDouble + sndValDouble;
                break;
            case sub:
                result = fstValDouble - sndValDouble;
                break;
            case mul:
                result = fstValDouble * sndValDouble;
                break;
            case div:
                if (sndValDouble == 0) {
                    System.out.println("분모에는 0이 들어갈 수 없습니다." + "\n");
                    return 0;
                }
                result = fstValDouble / sndValDouble;
                break;
        }
        //필수 LV2 setter 사용 데이터 저장
        savedata = fstVal + " " + operator.getSymbol() + " " + sndVal + " = " + result;
        setHistory(savedata); //setHistory 에서 저장
        return result;
    }

    // 필수 LV2 데이터 저장
    public void setHistory(String savedata){
        history.add(savedata);
        removeresult();
    }

    // 필수 LV2 getter 사용 데이터 반환
    public List<String> getHistory() {
        return new ArrayList<>(history);
    }

    // 필수 LV2 오래된 데이터 삭제
    public void removeresult(){
        if(history.size() > maxSize) {
            history.remove(0);
        }
    }

    // 도전 람다 & 스트림을 사용한 입력한 값보다 큰 결과값 출력
    public double extractVal(String history){
        String[] parts = history.split(" = ");
        try{
            return Double.parseDouble(parts[1].trim());
        } catch (NumberFormatException e){
            return 0;
        }
    }

    public List<Double>filterVal(Number value){
        return history.stream().map(this::extractVal)
                .filter(num -> num > value.doubleValue())
                .collect(Collectors.toList());
    }

}