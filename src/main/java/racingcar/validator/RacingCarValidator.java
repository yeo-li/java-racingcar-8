package racingcar.validator;

import java.util.Arrays;

public class RacingCarValidator {

    public static void validateCarNames(String[] carNames) {
        validateCarNamesNotEmpty(carNames);
        for (String carName : carNames) {
            validateCarName(carName);
        }
        validateNoDuplicateNames(carNames);
    }

    private static void validateCarNamesNotEmpty(String[] carNames) {
        if (carNames.length == 1 && carNames[0].isBlank()) {
            throw new IllegalArgumentException("자동차 이름이 입력되지 않았습니다.");
        }
    }

    private static void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }

        if (carName.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백이 불가능 합니다.");
        }

        if (!isAlphabetOnly(carName)) {
            throw new IllegalArgumentException("자동차 이름은 알파벳만 가능합니다.");
        }
    }

    private static void validateNoDuplicateNames(String[] arr) {
        if (Arrays.stream(arr).distinct().count() < arr.length) {
            throw new IllegalArgumentException("자동차 이름은 중복 될 수 없습니다.");
        }
    }

    private static boolean isAlphabetOnly(String input) {
        return input.matches("^[a-zA-Z]+$");
    }
}
