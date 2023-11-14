package christmas.promotion;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.promotion.SpecialPromotion;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SpecialPromotionTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 10, 25})
    void 스페셜_데이에_해당하는_경우_1000원_할인(int visitDate) {
        SpecialPromotion specialPromotion = SpecialPromotion.from(visitDate);

        assertThat(specialPromotion.getSpecialDiscount()).isEqualTo(1_000);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 16})
    void 스페셜_데이에_해당하지_않으면_할인적용_되지않음(int visitDate) {
        SpecialPromotion specialPromotion = SpecialPromotion.from(visitDate);

        assertThat(specialPromotion.getSpecialDiscount()).isEqualTo(0);
    }
}