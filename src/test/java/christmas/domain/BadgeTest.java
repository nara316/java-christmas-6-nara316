package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BadgeTest {

    @ParameterizedTest
    @ValueSource(ints = {5_000, 9_999})
    void 혜택_금액이_5000원_이상_9999이하인_경우_별_부여(int totalDiscount) {

        assertThat(Badge.from(totalDiscount).getLabel()).isEqualTo("별");
    }

    @ParameterizedTest
    @ValueSource(ints = {10_000, 19_999})
    void 혜택_금액이_10000원_이상_19999이하인_경우_트리_부여(int totalDiscount) {

        assertThat(Badge.from(totalDiscount).getLabel()).isEqualTo("트리");
    }

    @ParameterizedTest
    @ValueSource(ints = {20_000, 99_999})
    void 혜택_금액이_20000원_이상인_경우_별_부여(int totalDiscount) {

        assertThat(Badge.from(totalDiscount).getLabel()).isEqualTo("산타");
    }

    @ParameterizedTest
    @ValueSource(ints = {4_999, 1_000, 0})
    void 혜택_금액이_5000원_미만인_경우_없음_부여(int totalDiscount) {

        assertThat(Badge.from(totalDiscount).getLabel()).isEqualTo("없음");
    }
}