package racingcar.message;

public enum ErrorMessage {
    // 공통
    BLANK_ERROR_MESSAGE("공백만 입력되었습니다."),
    INVALID_INPUT_ERROR_MESSAGE("유효하지 않은 입력값입니다."),

    // 경주 자동차 입력 에러 메세지
    CAR_NAME_DUPLICATED_INPUT_ERROR_MESSAGE("자동차 이름이 중복 되었습니다"),
    CAR_COUNT_EXCESS_ERROR_MESSAGE("최대 자동차 등록 수를 초과했습니다."),
    CAR_NAME_BLANK_ERROR_MESSAGE("자동차 이름이 공백입니다."),
    CAR_NAME_LENGTH_EXCESS_ERROR_MESSAGE("자동차 이름은 최대 5자 입니다."),

    // 시도 횟수 입력 에러 메세지
    TRY_COUNT_EXCESS_ERROR_MESSAGE("최대 시도 횟수를 초과했습니다."),
    TRY_COUNT_IS_NOT_NUMBER_ERROR_MESSAGE("시도 횟수는 숫자여야합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        String prefix = "[ERROR] ";
        return prefix + message;
    }
}
