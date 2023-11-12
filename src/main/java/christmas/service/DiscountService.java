package christmas.service;

import christmas.domain.OrderResult;
import christmas.domain.PromotionResult;

public class DiscountService {

    public PromotionResult generatePromotionResult(int date, int totalPrice, OrderResult orderResult) {
        return PromotionResult.of(date, totalPrice, orderResult);
    }

    public int calculateTotalDiscount(PromotionResult promotionResult) {
        return promotionResult.calculateTotalDiscount();
    }
}
