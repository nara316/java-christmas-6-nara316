package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.order.Orders;
import org.junit.jupiter.api.Test;

class PromotionResultTest {

    @Test
    void 총_주문금액이_10000원_미만이면_모든할인_적용되지_않음() {
        VisitDate visitDate = VisitDate.from("1");
        String userInput = "타파스-1,제로콜라-1"; //8500원
        Orders orders = Orders.from(userInput);
        OrderResult orderResult = OrderResult.from(orders);
        TotalOrderPrice totalOrderPrice = TotalOrderPrice.from(orderResult);

        PromotionResult promotionResult = PromotionResult.of(
                visitDate, totalOrderPrice, orderResult);

        assertThat(promotionResult.calculateTotalDiscount()).isEqualTo(0);
    }

    @Test
    void 총_주문금액이_10000원_이상이면_중복할인_적용되는지_확인() {
        VisitDate visitDate = VisitDate.from("1"); //주말(메인디쉬 개당 2023원 할인), 크리스마스(1000원할인)
        String userInput = "티본스테이크-3,제로콜라-1"; //총 금액 12만원 이상이므로 샴페인증정(25,000원)
        Orders orders = Orders.from(userInput);
        OrderResult orderResult = OrderResult.from(orders);
        TotalOrderPrice totalOrderPrice = TotalOrderPrice.from(orderResult);

        PromotionResult promotionResult = PromotionResult.of(
                visitDate, totalOrderPrice, orderResult);

        assertThat(promotionResult.calculateTotalDiscount()).isEqualTo(32_069);
    }
}