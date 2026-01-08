package racingcar.constant;

public enum NumberConstant {
    RANDOM_MIN_VALUE(0),
    RANDOM_MAX_VALUE(9),
    CAN_MOVE(4),
    CAR_MAX_COUNT(1000);

    private final int constant;

    NumberConstant(int constant) {
        this.constant = constant;
    }

    public int getConstant() {
        return constant;
    }
}
