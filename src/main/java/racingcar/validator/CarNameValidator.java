package racingcar.validator;

import java.util.List;
import racingcar.message.ErrorMessage;
import racingcar.util.Parser;

public class CarNameValidator {

    public static void validate(String input) {
        InputValidator.requireNotBlank(input, ErrorMessage.BLANK_ERROR_MESSAGE.getMessage());
        List<String> names = Parser.parseInput(input, ",");
        for (String name : names) {
            InputValidator.requireNotBlank(name, ErrorMessage.BLANK_ERROR_MESSAGE.getMessage());
            validateCarNameRule(name);
        }
        InputValidator.requireNotDuplicate(names,
            ErrorMessage.CAR_NAME_DUPLICATED_INPUT_ERROR_MESSAGE.getMessage());
        validateCarNameCount(names);
    }

    private static void validateCarNameRule(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(
                ErrorMessage.INVALID_INPUT_ERROR_MESSAGE.getMessage());
        }
    }

    private static void validateCarNameCount(List<String> names) {
        if (names.size() > 10) {
            throw new IllegalArgumentException(
                ErrorMessage.CAR_COUNT_EXCESS_ERROR_MESSAGE.getMessage());
        }
    }
}
