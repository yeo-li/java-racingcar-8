package racingcar.validator;

import racingcar.message.ErrorMessage;

public class TryCountValidator {

    public static void validate(String input) {
        InputValidator.requireNotBlank(input, ErrorMessage.BLANK_ERROR_MESSAGE.getMessage());
        InputValidator.requireDigits(input, ErrorMessage.INVALID_INPUT_ERROR_MESSAGE.getMessage());
        int number = InputValidator.parseIntOrThrow(input,
            ErrorMessage.INVALID_INPUT_ERROR_MESSAGE.getMessage());
        validateTryCount(number);
    }

    private static void validateTryCount(int tryCnt) {
        if (1000 < tryCnt) {
            throw new IllegalArgumentException(
                ErrorMessage.INVALID_INPUT_ERROR_MESSAGE.getMessage());
        }
    }
}
