package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.Serializable;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class DeepCopyUtilTest {

    @Nested
    class DeepCopyTest {

        @Test
        void 직렬화_가능한_객체를_깊은_복사한다() {
            // given
            Address address = new Address("Seoul");
            Person original = new Person("Kim", address);

            // when
            Person copied = DeepCopyUtil.deepCopy(original);

            // then
            assertThat(copied).isNotSameAs(original);
            assertThat(copied.address).isNotSameAs(original.address);
            assertThat(copied.address.city).isEqualTo("Seoul");

            original.address.city = "Busan";
            assertThat(copied.address.city).isEqualTo("Seoul");
        }

        @Test
        void null_입력은_null을_반환한다() {
            // when
            Object result = DeepCopyUtil.deepCopy(null);

            // then
            assertThat(result).isNull();
        }

        @Test
        void 직렬화_불가능한_객체면_예외를_발생시킨다() {
            // when & then
            assertThatThrownBy(() -> DeepCopyUtil.deepCopy(new NotSerializable()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 직렬화 가능한 객체만 깊은 복사가 가능합니다.");
        }
    }

    private static class Person implements Serializable {

        private final String name;
        private final Address address;

        private Person(String name, Address address) {
            this.name = name;
            this.address = address;
        }
    }

    private static class Address implements Serializable {

        private String city;

        private Address(String city) {
            this.city = city;
        }
    }

    private static class NotSerializable {

    }
}
