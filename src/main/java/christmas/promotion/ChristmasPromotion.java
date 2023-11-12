package christmas.promotion;

import static christmas.constant.NumberConstant.CHRISTMAS_DISCOUNT;
import static christmas.constant.NumberConstant.CHRISTMAS_PROMOTION_DEADLINE;
import static christmas.constant.NumberConstant.PROMOTION_DISCOUNT;
import static christmas.constant.NumberConstant.PROMOTION_NOT_QUALIFIED;

public class ChristmasPromotion {

    private final int christmasDiscount;

    private ChristmasPromotion(int date) {
        this.christmasDiscount = calculateChristmasSale(date);
    }

    public static ChristmasPromotion from(int date) {
        return new ChristmasPromotion(date);
    }

    private int calculateChristmasSale(int date) {
        if (isChristmasQualified(date)) {
            return PROMOTION_DISCOUNT.getNumber() + (date - 1) * CHRISTMAS_DISCOUNT.getNumber();
        }
        return PROMOTION_NOT_QUALIFIED.getNumber();
    }

    private boolean isChristmasQualified(int date) {
        return date <= CHRISTMAS_PROMOTION_DEADLINE.getNumber();
    }

    public int getChristmasDiscount() {
        return christmasDiscount;
    }
}
