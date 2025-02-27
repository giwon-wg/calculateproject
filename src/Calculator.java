import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<String> history; //정보 은닉
    private static final int maxSize = 10;

    // 생성자
    public Calculator() {
        this.history = new ArrayList<>();
    }


    //기능
    public int calculate(int a, int b, char math_symbol) {
        int result = 0;
        String savedata;

        switch (math_symbol) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b == 0) {
                    System.out.println("분모에는 0이 들어갈 수 없습니다." + "\n");
                    return 0;
                }
                result = a / b;
                break;
        }

        savedata = a + " " + math_symbol + " " + b + " = " + result;
        setHistory(savedata); //setHistory 에서 저장
        return result;
    }

    // 데이터 저장
    public void setHistory(String savedata){
        history.add(savedata);
        removeresult();
    }

    // 원본 보호를 위해 복사본 반환
    public List<String> getHistory() {
        return new ArrayList<>(history);
    }

    //오래된 데이터 삭제 기능 구현
    public  void removeresult(){
        if(history.size() > maxSize) {
            history.remove(0);
        }
    }


}
