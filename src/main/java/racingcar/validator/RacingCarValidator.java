package racingcar.validator;

import java.util.Arrays;
import racingcar.exception.ExceptionMessage;

public class RacingCarValidator {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_ATTEMPT_COUNT = 0;
    private static final int MAX_ATTEMPT_COUNT = 1_0000;
    private static final String ALPHABET_REGEX = "^[a-zA-Z]+$";
    private static final int FIRST_INDEX = 0;
    private static final int SINGLE_NAME = 1;

    public static void validateCarNames(String[] carNames) {

        validateCarNamesNotEmpty(carNames);
        for (String carName : carNames) {
            validateCarName(carName);
        }
        validateNoDuplicateNames(carNames);
    }

    private static void validateCarNamesNotEmpty(String[] carNames) {

        if (carNames.length == SINGLE_NAME && carNames[FIRST_INDEX].isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_CAR_NAME.getMessage());
        }
    }

    private static void validateCarName(String carName) {

        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.TOO_LONG_CAR_NAME.getMessage());
        }

        if (carName.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.BLANK_CAR_NAME.getMessage());
        }

        if (!isAlphabetOnly(carName)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_CAR_NAME.getMessage());
        }
    }

    private static void validateNoDuplicateNames(String[] arr) {

        if (Arrays.stream(arr).distinct().count() < arr.length) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_CAR_NAME.getMessage());
        }
    }

    private static boolean isAlphabetOnly(String input) {

        return input.matches(ALPHABET_REGEX);
    }

    public static void validateAttemptCount(String input) {

        validateAttemptCountNotBlank(input);
        validateNumericOnly(input);
        validateAttemptCountRange(input);
    }

    private static void validateAttemptCountNotBlank(String input) {

        if (input.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_ATTEMPT_COUNT.getMessage());
        }
    }

    private static void validateNumericOnly(String input) {

        for (char number : input.toCharArray()) {
            if (!Character.isDigit(number)) {
                throw new IllegalArgumentException(
                    ExceptionMessage.NON_NUMERIC_ATTEMPT_COUNT.getMessage());
            }
        }
    }

    private static void validateAttemptCountRange(String input) {

        try {
            int AttemptCount = Integer.parseInt(input);
            if (AttemptCount < MIN_ATTEMPT_COUNT || AttemptCount > MAX_ATTEMPT_COUNT) {
                throw new IllegalArgumentException(
                    ExceptionMessage.OUT_OF_RANGE_ATTEMPT_COUNT.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                ExceptionMessage.OUT_OF_RANGE_ATTEMPT_COUNT.getMessage());
        }
    }
}
