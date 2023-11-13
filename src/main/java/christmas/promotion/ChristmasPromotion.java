package christmas.promotion;

import static christmas.constant.NumberConstant.CHRISTMAS_DISCOUNT;
import static christmas.constant.NumberConstant.CHRISTMAS_PROMOTION_DEADLINE;
import static christmas.constant.NumberConstant.PROMOTION_DISCOUNT;
import static christmas.constant.NumberConstant.PROMOTION_NOT_QUALIFIED;

public class ChristmasPromotion {

    private final int christmasDiscount;

    private ChristmasPromotion(int visitDate) {
        this.christmasDiscount = calculateChristmasSale(visitDate);
    }

    public static ChristmasPromotion from(int visitDate) {
        return new ChristmasPromotion(visitDate);
    }

    private int calculateChristmasSale(int visitDate) {
        if (isChristmasQualified(visitDate)) {
            return PROMOTION_DISCOUNT.getNumber() + (visitDate - 1) * CHRISTMAS_DISCOUNT.getNumber();
        }
        return PROMOTION_NOT_QUALIFIED.getNumber();
    }

    private boolean isChristmasQualified(int visitDate) {
        return visitDate <= CHRISTMAS_PROMOTION_DEADLINE.getNumber();
    }

    public int getChristmasDiscount() {
        return christmasDiscount;
    }
}
