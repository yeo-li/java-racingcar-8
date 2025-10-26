package racingcar.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarValidatorTest {

    @Test
    @DisplayName("자동차 이름이 5자를 초과하는 경우")
    void 자동차_이름_다섯글자_초과() {
        // given
        String[] input = {"pobi", "name", "seong", "seongyeol"};

        // when & then
        assertThatThrownBy(() -> {
            RacingCarValidator.validateCarNames(input);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름은 5글자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름에 중복이 있는 경우")
    void 자동차_이름_중복() {
        // given
        String[] input = {"seyeo", "pobi", "seyeo"};

        // when & then
        assertThatThrownBy(() -> {
            RacingCarValidator.validateCarNames(input);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름은 중복 될 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름이 \"\"인 경우")
    void 자동차_이름_공백() {
        // given
        String[] input = {"", "pobi", "", ""};

        // when & then
        assertThatThrownBy(() -> {
            RacingCarValidator.validateCarNames(input);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름은 공백이 불가능 합니다.");
    }

    @Test
    @DisplayName("\"\", \" \" 처럼 공백만 입력한 경우")
    void 공백만_입력() {
        // given
        String[] input = {""};

        // when & then
        assertThatThrownBy(() -> {
            RacingCarValidator.validateCarNames(input);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름이 입력되지 않았습니다.");
    }

    @Test
    @DisplayName("알파벳, \",\"과 공백을 제외한 다른 문자가 들어온 경우")
    void 자동차_이름_알파벳_쉼표_외_입력() {
        // given
        String[] input = {"pobi", "user-", "jun"};

        // when & then
        assertThatThrownBy(() -> {
            RacingCarValidator.validateCarNames(input);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름은 알파벳만 가능합니다.");
    }
}