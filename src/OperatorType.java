//도전과제 Enum 구현
public enum OperatorType {
    add('+'), sub('-'), mul('*'), div('/'),  pow('^'), mod('%'),
    log('l'), sin('s'), cos('c'), tan('t'), sqrt('q');

    private final char symbol;
    OperatorType(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    //입력 받은 기호와 해당하는 Enum 찾기
    public static OperatorType getOperatorType(char symbol) {
        for (OperatorType operatorType : OperatorType.values()) {
            if (operatorType.getSymbol() == symbol) {
                return operatorType;
            }
        }
        throw new IllegalArgumentException("연산 기호를 확인해주세요");
    }

    //단항식 확인 메서드
    public boolean monomial(){
        return this == sqrt || this == log || this == sin || this == cos || this == tan;
    }

}
