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
        RacingCarValidator.validateAttemptCount(cleanedInput);

        return Integer.parseInt(cleanedInput);
    }

}
