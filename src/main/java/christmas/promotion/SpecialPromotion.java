package christmas.promotion;

import static christmas.constant.NumberConstant.SPECIAL_DISCOUNT;

import christmas.constant.SpecialDayConstant;

public class SpecialPromotion {

    public int calculateSpecialSale(int date) {
        if (SpecialDayConstant.isSpecialDay(date)) {
            return SPECIAL_DISCOUNT.getNumber();
        }
        return 0;
    }
}
