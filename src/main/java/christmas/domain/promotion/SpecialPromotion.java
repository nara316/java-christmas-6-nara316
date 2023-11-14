package christmas.domain.promotion;

import static christmas.constant.NumberConstant.PROMOTION_NOT_APPLIED;
import static christmas.constant.NumberConstant.PROMOTION_SPECIAL_DISCOUNT;

import christmas.constant.promotion.SpecialPromotionConstant;

public class SpecialPromotion {

    private final int specialDiscount;

    private SpecialPromotion(int visitDate) {
        this.specialDiscount = calculateSpecialSale(visitDate);
    }

    public static SpecialPromotion from(int visitDate) {
        return new SpecialPromotion(visitDate);
    }

    private int calculateSpecialSale(int visitDate) {
        if (SpecialPromotionConstant.isSpecialDay(visitDate)) {
            return PROMOTION_SPECIAL_DISCOUNT.getNumber();
        }
        return PROMOTION_NOT_APPLIED.getNumber();
    }

    public int getSpecialDiscount() {
        return specialDiscount;
    }
}
