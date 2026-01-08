package racingcar.config;

import racingcar.controller.RacingCarController;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {

    public RacingCarController racingCarController() {
        return new RacingCarController(racingCarService(), inputView(), outputView());
    }

    public RacingCarService racingCarService() {
        return new RacingCarService();
    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }
}
