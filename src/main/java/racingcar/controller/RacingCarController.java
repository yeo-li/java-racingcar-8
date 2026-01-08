package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.util.Parser;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TryCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        List<Car> cars = inputCarNames();
        int tryCount = inputTryCount();
        List<Car> endCars = race(cars, tryCount);
        List<Car> winners = judgeWinners(endCars);
        outputView.printRacingWinners(winners);
    }

    private List<Car> inputCarNames() {
        String input = inputView.inputCarName();
        CarNameValidator.validate(input);
        List<String> names = Parser.parseInput(input, ",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private int inputTryCount() {
        String input = inputView.inputTryCount();
        TryCountValidator.validate(input);
        return Integer.parseInt(input);
    }

    private List<Car> race(List<Car> cars, int tryCnt) {
        outputView.printStatusResultMessage();
        for (int i = 0; i < tryCnt; i++) {
            for (Car car : cars) {
                car.moveForward();
            }
            outputView.printRacingStatus(cars);
        }
        return cars;
    }

    private List<Car> judgeWinners(List<Car> cars) {
        List<Car> winners = new ArrayList<>();
        cars.sort((o1, o2) -> o2.getDistance() - o1.getDistance());
        int max = cars.getFirst().getDistance();
        for (Car car : cars) {
            if (max == car.getDistance()) {
                winners.add(car);
            }
        }
        return winners;
    }
}
