package racingcar.exception;

public enum ExceptionMessage {
    EMPTY_CAR_NAME("자동차 이름이 입력되지 않았습니다."),
    TOO_LONG_CAR_NAME("자동차 이름은 5글자를 초과할 수 없습니다."),
    BLANK_CAR_NAME("자동차 이름은 공백이 불가능 합니다."),
    INVALID_CAR_NAME("자동차 이름은 알파벳만 가능합니다."),
    DUPLICATE_CAR_NAME("자동차 이름은 중복 될 수 없습니다."),
    EMPTY_ATTEMPT_COUNT("시도 횟수가 입력되지 않았습니다."),
    NON_NUMERIC_ATTEMPT_COUNT("시도 횟수에는 숫자만 입력할 수 있습니다."),
    OUT_OF_RANGE_ATTEMPT_COUNT("시도 횟수의 범위를 초과했습니다.");

    private final String message;


    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
