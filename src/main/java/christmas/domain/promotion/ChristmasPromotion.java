package christmas.domain.promotion;

import static christmas.constant.NumberConstant.PROMOTION_CHRISTMAS_DISCOUNT;
import static christmas.constant.NumberConstant.PROMOTION_CHRISTMAS_DISCOUNT_PER_DAY;
import static christmas.constant.NumberConstant.PROMOTION_CHRISTMAS_DEADLINE;
import static christmas.constant.NumberConstant.PROMOTION_NOT_APPLIED;

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
            return PROMOTION_CHRISTMAS_DISCOUNT.getNumber() +
                    (visitDate - 1) * PROMOTION_CHRISTMAS_DISCOUNT_PER_DAY.getNumber();
        }
        return PROMOTION_NOT_APPLIED.getNumber();
    }

    private boolean isChristmasQualified(int visitDate) {
        return visitDate <= PROMOTION_CHRISTMAS_DEADLINE.getNumber();
    }

    public int getChristmasDiscount() {
        return christmasDiscount;
    }
}
