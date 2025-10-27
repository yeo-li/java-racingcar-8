package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {

    private static final int MIN_RANDOM = 0;
    private static final int MAX_RANDOM = 9;
    private static final int MOVE_THRESHOLD = 4;

    private final String name;
    private int distance;


    public RacingCar(String name) {
        
        this.name = name;
        this.distance = 0;
    }

    public String getName() {

        return name;
    }

    public int getDistance() {

        return distance;
    }

    public void moveForward() {

        int moveSignal = Randoms.pickNumberInRange(MIN_RANDOM, MAX_RANDOM);
        if (canMove(moveSignal)) {
            this.distance += 1;
        }
    }

    private boolean canMove(int moveSignal) {

        return moveSignal >= MOVE_THRESHOLD;
    }

    @Override
    public String toString() {

        return this.name + " : " + "-".repeat(this.distance);
    }
}
