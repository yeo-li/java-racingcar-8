package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final List<RacingCar> racingCars;
    private final int attemptCount;
    private final List<String> roundResults;

    public RacingGame(List<RacingCar> racingCars, int attemptCount) {

        this.racingCars = racingCars;
        this.attemptCount = attemptCount;
        this.roundResults = new ArrayList<>();
    }

    public List<String> getRoundResults() {
        return roundResults;
    }

    public void moveAllCars() {

        for (RacingCar racingCar : racingCars) {
            racingCar.moveForward();
        }
    }

    public void race() {

        for (int i = 0; i < attemptCount; i++) {
            moveAllCars();
            roundResults.add(this.toString());
        }
    }

    @Override
    public String toString() {

        String status = "";
        for (RacingCar racingCar : racingCars) {
            status += racingCar.toString() + "\n";
        }

        return status;
    }
}
