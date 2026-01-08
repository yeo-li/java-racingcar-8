package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.NumberConstant;
import racingcar.validator.CarNameValidator;

public class Car {

    private final String name;
    private int distance;

    public Car(String name) {
        CarNameValidator.validate(name);
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public String status() {
        return String.format("%s : %s", name, "-".repeat(distance));
    }

    public void moveForward() {
        if (canMove()) {
            distance++;
        }
    }

    private boolean canMove() {
        int random = Randoms.pickNumberInRange(NumberConstant.RANDOM_MIN_VALUE.getConstant(),
            NumberConstant.RANDOM_MAX_VALUE.getConstant());
        return random >= NumberConstant.CAN_MOVE.getConstant();
    }
}
