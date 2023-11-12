package christmas.promotion;

import christmas.constant.MenuConstant;

public class GiftPromotion {

    private final int giftDiscount;

    private GiftPromotion(int totalPrice) {
        this.giftDiscount = calculateGiftDiscount(totalPrice);
    }

    public static GiftPromotion from(int totalPrice) {
        return new GiftPromotion(totalPrice);
    }

    private int calculateGiftDiscount(int totalPrice) {
        return MenuConstant.checkGiftQualified(totalPrice);
    }

    public int getGiftDiscount() {
        return giftDiscount;
    }
}
