package christmas.promotion;

import static christmas.constant.NumberConstant.CHRISTMAS_DISCOUNT;
import static christmas.constant.NumberConstant.CHRISTMAS_PROMOTION_DEADLINE;
import static christmas.constant.NumberConstant.PROMOTION_DISCOUNT;

import christmas.constant.PromotionConstant;

public class ChristmasPromotion {

    public int calculateChristmasSale(int date) {
        if (isChristmasQualified(date)) {
            return PROMOTION_DISCOUNT.getNumber() + (date - 1) * CHRISTMAS_DISCOUNT.getNumber();
        }
        return PromotionConstant.getNotQualifiedPrice();
    }

    private boolean isChristmasQualified(int date) {
        return date <= CHRISTMAS_PROMOTION_DEADLINE.getNumber();
    }
}
