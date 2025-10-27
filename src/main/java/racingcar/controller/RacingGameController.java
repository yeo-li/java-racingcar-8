package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingGame;
import racingcar.service.RacingCarService;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RacingCarService racingCarService = new RacingCarService();
    private final RacingGameService racingGameService = new RacingGameService();

    public void run() {
        String carNamesInput = inputView.inputCarNames();
        List<RacingCar> carNames = racingCarService.registerCars(carNamesInput);
        
        String tryCountInput = inputView.inputTryCount();
        int attemptCount = racingCarService.SaveAttemptCount(tryCountInput);

        RacingGame game = new RacingGame(carNames, attemptCount);

        List<String> gameResult = racingGameService.race(game);
        outputView.printRacingResult(gameResult);

        List<RacingCar> winners = racingGameService.calculateWinners(carNames);
        outputView.printWinners(winners);
    }
}
