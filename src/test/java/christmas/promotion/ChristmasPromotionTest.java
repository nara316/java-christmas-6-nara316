package christmas.promotion;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.promotion.ChristmasPromotion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ChristmasPromotionTest {

    @ParameterizedTest
    @ValueSource(ints = {26, 28, 31})
    void 크리스마스_이후부터는_혜택이_적용되지_않는지_확인(int visitDate) {
        ChristmasPromotion christmasPromotion = ChristmasPromotion.from(visitDate);

        assertThat(christmasPromotion.getChristmasDiscount()).isEqualTo(0);
    }

    @Test
    void 날짜가_유효한_경우_혜택이_정상적용되는지_확인() {
        int visitDate = 10; //1일을 1000원을 시작으로 하루씩 100원이 증가한다고 가정했을 때, 1900원을 혜택받아야 한다.

        assertThat(ChristmasPromotion.from(visitDate).getChristmasDiscount()).isEqualTo(1_900);
    }
}