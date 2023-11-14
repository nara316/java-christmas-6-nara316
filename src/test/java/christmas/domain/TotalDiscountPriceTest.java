package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.order.Orders;
import org.junit.jupiter.api.Test;

class TotalDiscountPriceTest {

    @Test
    void 총_혜택금액이_알맞게_계산되는지_확인() {
        VisitDate visitDate = VisitDate.from("2"); //주말(메인디쉬 개당 2023원), 크리스마스(1100원)
        String userInput = "티본스테이크-3,제로콜라-1"; //총 금액 12만원 이상이므로 샴페인증정(25,000원)
        PromotionResult promotionResult = generatePromotionResult(visitDate, userInput);
        TotalDiscountPrice totalDiscountPrice = TotalDiscountPrice.from(promotionResult);

        assertThat(totalDiscountPrice.getTotalPrice()).isEqualTo(32_169);
    }

    @Test
    void 증정_메뉴가_있다면_할인금액에서_제외되는지_확인() {
        VisitDate visitDate = VisitDate.from("3"); //평일(디저트 개당 2023원), 크리스마스(1200원), 스페셜데이(1000원)
        String userInput = "바비큐립-5,아이스크림-1"; //총 금액 12만원 이상이므로 샴페인증정(25,000원)
        PromotionResult promotionResult = generatePromotionResult(visitDate, userInput);
        TotalDiscountPrice totalDiscountPrice = TotalDiscountPrice.from(promotionResult);
        int totalDiscountPriceAfterGift = totalDiscountPrice.calculateTotalDiscountWithoutGift(promotionResult);

        assertThat(totalDiscountPriceAfterGift).isEqualTo(4_223);
    }

    private PromotionResult generatePromotionResult(VisitDate visitDate, String userInput) {
        Orders orders = Orders.from(userInput);
        OrderResult orderResult = OrderResult.from(orders);
        TotalOrderPrice totalOrderPrice = TotalOrderPrice.from(orderResult);

        return PromotionResult.of(
                visitDate, totalOrderPrice, orderResult);
    }
}