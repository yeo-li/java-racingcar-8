package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CarTest {

    public static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Nested
    class moveForwardTest {

        @Test
        void 랜덤수가_4_이상이면_전진한다() {
            // given
            Car car = new Car("pobi");

            // when
            assertRandomNumberInRangeTest(
                () -> {
                    for (int i = 0; i < 3; i++) {
                        car.moveForward();
                    }
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
            );

            // then
            Assertions.assertEquals(2, car.getDistance());
        }
    }

    @Nested
    class StatusTest {

        @Test
        void 자동차_이름과_이동_거리를_포맷에_맞게_출력_해야_한다() {
            // given
            Car car = new Car("pobi");

            // when
            assertRandomNumberInRangeTest(
                () -> {
                    for (int i = 0; i < 2; i++) {
                        car.moveForward();
                    }
                },
                MOVING_FORWARD, STOP
            );

            // then
            Assertions.assertEquals("pobi : -", car.status());
        }
    }
}