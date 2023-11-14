package christmas.domain.promotion;

import christmas.constant.MenuConstant;

public class GiftPromotion {

    private final int giftDiscount;

    private GiftPromotion(int totalOrderPrice) {
        this.giftDiscount = calculateGiftDiscount(totalOrderPrice);
    }

    public static GiftPromotion from(int totalOrderPrice) {
        return new GiftPromotion(totalOrderPrice);
    }

    private int calculateGiftDiscount(int totalOrderPrice) {
        return MenuConstant.calculateGiftPrice(totalOrderPrice);
    }

    public int getGiftDiscount() {
        return giftDiscount;
    }
}
