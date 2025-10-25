package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.RacingCar;

class RacingCarServiceTest {

    private final RacingCarService racingCarService = new RacingCarService();

    @Nested
    @DisplayName("RegisterCars() 메서드")
    class RegisterCarsTest {

        static Stream<Arguments> provideNameLists() {

            return Stream.of(
                Arguments.of("pobi,woni,jun", List.of("pobi", "woni", "jun")),
                Arguments.of("userA, userB, userC", List.of("userA", "userB", "userC"))
            );
        }

        @ParameterizedTest
        @DisplayName("자동차 등록 성공")
        @MethodSource("provideNameLists")
        void 자동차_등록_성공(String input, List<String> expectedNames) {

            // when
            List<RacingCar> racingCars = racingCarService.registerCars(input);

            List<String> resultNames = racingCars.stream()
                .map(RacingCar::getName)
                .toList();

            // then
            assertThat(resultNames).isEqualTo(expectedNames);
        }

        @Test
        @DisplayName("자동차 등록 실패 - 자동차 이름이 5자를 초과하는 경우")
        void 자동차_이름_다섯글자_초과() {
            // given
            String input = " pobi,name, seongyeol";

            // when & then
            assertThatThrownBy(() -> {
                racingCarService.registerCars(input);
            })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5글자를 초과할 수 없습니다.");
        }

        @Test
        @DisplayName("자동차 등록 실패 - 자동차 이름에 중복이 있는 경우")
        void 자동차_이름_중복() {
            // given
            String input = "pobi, pobi";

            // when & then
            assertThatThrownBy(() -> {
                racingCarService.registerCars(input);
            })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복 될 수 없습니다.");
        }

        @Test
        @DisplayName("자동차 등록 실패 - 자동차 이름이 \"\"인 경우")
        void 자동차_이름_공백() {
            // given
            String input = ", pobi, ,";

            // when & then
            assertThatThrownBy(() -> {
                racingCarService.registerCars(input);
            })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 공백이 불가능 합니다.");
        }

        @Test
        @DisplayName("자동차 등록 실패 - \"\", \" \" 처럼 공백만 입력한 경우")
        void 공백만_입력() {
            // given
            String input = "    ";

            // when & then
            assertThatThrownBy(() -> {
                racingCarService.registerCars(input);
            })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 입력되지 않았습니다.");
        }

        @Test
        @DisplayName("자동차 등록 실패 - 알파벳, \",\"과 공백을 제외한 다른 문자가 들어온 경우")
        void 자동차_이름_알파벳_쉼표_외_입력() {
            // given
            String input = "pobi, user2, jun";

            // when & then
            assertThatThrownBy(() -> {
                racingCarService.registerCars(input);
            })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 알파벳만 가능합니다.");
        }
    }
}