package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    private RacingCar racingCar;

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Nested
    @DisplayName("moveForward() 메서드")
    class MoveForwardTest {

        @Test
        void 전진_성공() {
            // given
            racingCar = new RacingCar("test");
            int expected = 1;

            // when
            assertRandomNumberInRangeTest(
                () -> {
                    racingCar.moveForward();
                },
                MOVING_FORWARD
            );

            // then
            assertThat(racingCar.getDistance()).isEqualTo(expected);
        }

        @Test
        void 전진_실패() {
            // given
            racingCar = new RacingCar("test");
            int expected = 0;

            // when
            assertRandomNumberInRangeTest(
                () -> {
                    racingCar.moveForward();
                },
                STOP
            );

            // then
            assertThat(racingCar.getDistance()).isEqualTo(expected);
        }
    }


}