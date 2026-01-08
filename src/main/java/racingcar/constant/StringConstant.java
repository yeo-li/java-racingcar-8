package racingcar.constant;

public enum StringConstant {
    DELIMITER(","),
    DELIMITER_NAME("쉼표");

    private final String constant;

    StringConstant(String constant) {
        this.constant = constant;
    }

    public String getConstant() {
        return constant;
    }
}
