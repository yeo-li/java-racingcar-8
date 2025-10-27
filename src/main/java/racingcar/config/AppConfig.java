package racingcar.config;

import racingcar.controller.RacingGameController;
import racingcar.service.RacingGameInputService;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {

    public RacingGameController racingGameController() {
        return new RacingGameController(
            inputView(),
            outputView(),
            racingGameInputService(),
            racingGameService()
        );
    }

    private RacingGameInputService racingGameInputService() {
        return new RacingGameInputService();
    }

    private RacingGameService racingGameService() {
        return new RacingGameService();
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }
}