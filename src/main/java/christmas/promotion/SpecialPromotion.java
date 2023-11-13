package christmas.promotion;

import static christmas.constant.NumberConstant.PROMOTION_DISCOUNT;
import static christmas.constant.NumberConstant.PROMOTION_NOT_QUALIFIED;

import christmas.constant.promotion.SpecialDayConstant;

public class SpecialPromotion {

    private final int specialDiscount;

    private SpecialPromotion(int visitDate) {
        this.specialDiscount = calculateSpecialSale(visitDate);
    }

    public static SpecialPromotion from(int visitDate) {
        return new SpecialPromotion(visitDate);
    }

    private int calculateSpecialSale(int visitDate) {
        if (SpecialDayConstant.isSpecialDay(visitDate)) {
            return PROMOTION_DISCOUNT.getNumber();
        }
        return PROMOTION_NOT_QUALIFIED.getNumber();
    }

    public int getSpecialDiscount() {
        return specialDiscount;
    }
}
