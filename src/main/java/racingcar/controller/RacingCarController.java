package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.util.Parser;
import racingcar.validator.CarNameValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        List<Car> cars = inputCarNames();
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
}
