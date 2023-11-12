package christmas.promotion;

import static christmas.constant.NumberConstant.PROMOTION_DISCOUNT;

import christmas.constant.PromotionConstant;
import christmas.constant.SpecialDayConstant;

public class SpecialPromotion {

    public int calculateSpecialSale(int date) {
        if (SpecialDayConstant.isSpecialDay(date)) {
            return PROMOTION_DISCOUNT.getNumber();
        }
        return PromotionConstant.getNotQualifiedPrice();
    }
}
