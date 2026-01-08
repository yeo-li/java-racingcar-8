package racingcar.message;

public enum ErrorMessage {
    BLANK_ERROR_MESSAGE("공백만 입력되었습니다."),
    INVALID_INPUT_ERROR_MESSAGE("유효하지 않은 입력값입니다."),
    CAR_NAME_DUPLICATED_INPUT_ERROR_MESSAGE("자동차 이름이 중복 되었습니다"),
    CAR_COUNT_EXCESS_ERROR_MESSAGE("최대 자동차 등록 수를 초과했습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        String prefix = "[ERROR] ";
        return prefix + message;
    }
}
