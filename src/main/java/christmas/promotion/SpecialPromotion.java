package christmas.promotion;

import static christmas.constant.NumberConstant.PROMOTION_DISCOUNT;

import christmas.constant.PromotionConstant;
import christmas.constant.SpecialDayConstant;

public class SpecialPromotion {

    private final int specialDiscount;

    private SpecialPromotion(int date) {
        this.specialDiscount = calculateSpecialSale(date);
    }

    public static SpecialPromotion from(int date) {
        return new SpecialPromotion(date);
    }

    private int calculateSpecialSale(int date) {
        if (SpecialDayConstant.isSpecialDay(date)) {
            return PROMOTION_DISCOUNT.getNumber();
        }
        return PromotionConstant.getNotQualifiedPrice();
    }
}
