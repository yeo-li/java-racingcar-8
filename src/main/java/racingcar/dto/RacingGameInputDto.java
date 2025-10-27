package racingcar.dto;

import java.util.List;
import racingcar.domain.RacingCar;

public class RacingGameInputDto {

    private final List<RacingCar> racingCars;
    private final int attemptCount;

    public RacingGameInputDto(List<RacingCar> racingCars, int attemptCount) {
        this.racingCars = racingCars;
        this.attemptCount = attemptCount;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
