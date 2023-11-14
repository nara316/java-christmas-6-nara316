package christmas.service;

import christmas.domain.OrderResult;
import christmas.domain.PromotionResult;
import christmas.domain.TotalOrderPrice;
import christmas.domain.VisitDate;

public class PromotionService {

    public PromotionResult generatePromotionResult(VisitDate visitDate, TotalOrderPrice totalPrice, OrderResult orderResult) {
        return PromotionResult.of(visitDate, totalPrice, orderResult);
    }

    public int calculateTotalDiscount(PromotionResult promotionResult) {
        return promotionResult.calculateTotalDiscount();
    }
}
