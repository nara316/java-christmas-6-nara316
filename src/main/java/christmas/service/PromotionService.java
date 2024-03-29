package christmas.service;

import christmas.domain.Badge;
import christmas.domain.OrderResult;
import christmas.domain.PromotionResult;
import christmas.domain.TotalDiscountPrice;
import christmas.domain.TotalOrderPrice;
import christmas.domain.VisitDate;

public class PromotionService {

    public PromotionResult generatePromotionResult(
            VisitDate visitDate, TotalOrderPrice totalPrice, OrderResult orderResult) {
        return PromotionResult.of(visitDate, totalPrice, orderResult);
    }

    public TotalDiscountPrice generateTotalDiscountPrice(PromotionResult promotionResult) {
        return TotalDiscountPrice.from(promotionResult);
    }

    public Badge generateBadge(TotalDiscountPrice totalDiscountPrice) {
        return Badge.from(totalDiscountPrice.getTotalPrice());
    }
}
