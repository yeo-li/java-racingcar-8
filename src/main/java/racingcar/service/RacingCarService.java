package racingcar.service;

import java.util.List;
import racingcar.converter.RacingCarConverter;
import racingcar.domain.RacingCar;
import racingcar.util.Parser;
import racingcar.validator.RacingCarValidator;

public class RacingCarService {

    private final RacingCarConverter racingCarConverter = new RacingCarConverter();

    public List<RacingCar> registerCars(String input) {

        String[] carNames = Parser.parseInput(input);
        RacingCarValidator.validateCarNames(carNames);

        return racingCarConverter.convertRacingCarList(carNames);
    }

    public int SaveAttemptCount(String input) {

        String cleanedInput = Parser.removeAllSpaces(input);
        validate(cleanedInput);
        return Integer.parseInt(cleanedInput);
    }

    private void validate(String input) {
        
        validateAttemptCountNotBlank(input);
        validateNumericOnly(input);
        validateAttemptCountRange(input);
    }

    private void validateAttemptCountNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("시도 횟수가 입력되지 않았습니다.");
        }
    }

    private void validateNumericOnly(String input) {
        for (char number : input.toCharArray()) {
            if (!Character.isDigit(number)) {
                throw new IllegalArgumentException("시도 횟수에는 숫자만 입력할 수 있습니다.");
            }
        }
    }

    private void validateAttemptCountRange(String input) {
        try {
            int AttemptCount = Integer.parseInt(input);
            if (AttemptCount < 0 || AttemptCount > 10000) {
                throw new IllegalArgumentException("시도 횟수의 범위를 초과했습니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수의 범위를 초과했습니다.");
        }
    }
}
