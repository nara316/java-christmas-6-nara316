package christmas.promotion;

import christmas.constant.MenuConstant;

public class GiftPromotion {

    private final int giftDiscount;

    private GiftPromotion(int totalPrice) {
        this.giftDiscount = caculateGiftDiscount(totalPrice);
    }

    public static GiftPromotion from(int totalPrice) {
        return new GiftPromotion(totalPrice);
    }

    private int caculateGiftDiscount(int totalPrice) {
        return MenuConstant.checkGiftQualified(totalPrice);
    }

    public int getGiftDiscount() {
        return giftDiscount;
    }
}
