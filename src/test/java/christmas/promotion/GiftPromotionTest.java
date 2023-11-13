package christmas.promotion;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GiftPromotionTest {

    @ParameterizedTest
    @ValueSource(ints = {119_999, 15_000})
    void 총_주문금액이_12만원_미만일_경우_혜택이_제공되지_않는지_확인(int totalOrderPrice) {
        GiftPromotion giftPromotion = GiftPromotion.from(totalOrderPrice);

        assertThat(giftPromotion.getGiftDiscount()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {120_000, 155_000})
    void 총_주문금액이_12만원_이상일_경우_혜택이_제공되는지_확인(int totalOrderPrice) {
        GiftPromotion giftPromotion = GiftPromotion.from(totalOrderPrice);

        assertThat(giftPromotion.getGiftDiscount()).isEqualTo(25_000);
    }
}