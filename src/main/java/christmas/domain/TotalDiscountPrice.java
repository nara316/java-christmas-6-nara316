package christmas.domain;

import christmas.constant.MenuConstant;
import christmas.constant.promotion.PromotionConstant;

public class TotalDiscountPrice {

    private final int totalPrice;

    private TotalDiscountPrice(PromotionResult promotionResult) {
        this.totalPrice = generateOrderResult(promotionResult);
    }

    public static TotalDiscountPrice from(PromotionResult promotionResult) {
        return new TotalDiscountPrice(promotionResult);
    }

    private int generateOrderResult(PromotionResult promotionResult) {
        return promotionResult.getPromotionResult().values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int calculateTotalDiscountWithoutGift(PromotionResult promotionResult) {
        if (PromotionConstant.isGiftApplied(promotionResult.getPromotionResult())) {
            return totalPrice - MenuConstant.getGiftPrice();
        }
        return totalPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
