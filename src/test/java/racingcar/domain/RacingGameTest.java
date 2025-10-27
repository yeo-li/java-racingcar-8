package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Nested
    @DisplayName("moveAllCars() 테스트")
    class MoveAllCarsTest {

        @Test
        @DisplayName("모든 자동차가 한 칸씩 전진")
        void 모든_자동차가_한_칸씩_전진() {
            // given
            List<RacingCar> cars = List.of(
                new RacingCar("pobi"),
                new RacingCar("woni"),
                new RacingCar("jun")
            );
            RacingGame game = new RacingGame(cars, 3);
            String expected = "pobi : -\nwoni : -\njun : -\n";

            // when
            assertRandomNumberInRangeTest(
                () -> {
                    game.moveAllCars();
                },
                MOVING_FORWARD
            );
            String actual = game.toString();

            // then
            assertThat(actual).isEqualTo(expected);
        }

        @Test
        @DisplayName("모든 자동차가 정지")
        void 모든_자동차가_정치() {
            // given
            List<RacingCar> cars = List.of(
                new RacingCar("pobi"),
                new RacingCar("woni"),
                new RacingCar("jun")
            );
            RacingGame game = new RacingGame(cars, 3);
            String expected = "pobi : \nwoni : \njun : \n";

            // when
            assertRandomNumberInRangeTest(
                () -> {
                    game.moveAllCars();
                },
                STOP
            );
            String actual = game.toString();

            // then
            assertThat(actual).isEqualTo(expected);
        }

    }

    @Nested
    @DisplayName("toString() 테스트")
    class ToStringTest {

        @Test
        @DisplayName("toString()이 각 자동차의 상태를 줄바꿈으로 연결하여 반환한다")
        void 자동차_상태_출력_형식() {
            // given
            List<RacingCar> cars = List.of(
                new RacingCar("pobi"),
                new RacingCar("woni"),
                new RacingCar("jun")
            );
            RacingGame game = new RacingGame(cars, 1);
            String expected = "pobi : -\nwoni : -\njun : -\n";

            // when
            assertRandomNumberInRangeTest(
                () -> {
                    game.moveAllCars();
                },
                MOVING_FORWARD
            );

            String result = game.toString();

            // then
            assertThat(result).isEqualTo(expected);
        }
    }
}