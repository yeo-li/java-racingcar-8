package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingGame;

public class RacingGameService {

    private static final int COMPARE_STANDARD = 0;

    public List<String> race(RacingGame game) {

        game.race();

        return game.getRoundResults();
    }

    public List<RacingCar> calculateWinners(List<RacingCar> racingCars) {

        List<RacingCar> winners = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            if (isWinner(racingCar, racingCars)) {
                winners.add(racingCar);
            }
        }

        return winners;
    }

    private boolean isWinner(RacingCar racingCar, List<RacingCar> racingCars) {

        for (RacingCar car : racingCars) {
            if (racingCar.compareTo(car) < COMPARE_STANDARD) {
                return false;
            }
        }

        return true;
    }
}
