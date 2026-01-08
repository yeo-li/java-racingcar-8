package racingcar.validator;

import racingcar.constant.NumberConstant;
import racingcar.message.ErrorMessage;

public class TryCountValidator {

    public static void validate(String input) {
        InputValidator.requireNotBlank(input, ErrorMessage.BLANK_ERROR_MESSAGE.getMessage());
        InputValidator.requireDigits(input,
            ErrorMessage.TRY_COUNT_IS_NOT_NUMBER_ERROR_MESSAGE.getMessage());
        int number = InputValidator.parseIntOrThrow(input,
            ErrorMessage.TRY_COUNT_EXCESS_ERROR_MESSAGE.getMessage());
        validateTryCount(number);
    }

    private static void validateTryCount(int tryCnt) {
        if (NumberConstant.CAR_MAX_COUNT.getConstant() < tryCnt) {
            throw new IllegalArgumentException(
                ErrorMessage.TRY_COUNT_EXCESS_ERROR_MESSAGE.getMessage());
        }
    }
}
