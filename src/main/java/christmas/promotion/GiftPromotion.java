package christmas.promotion;

import static christmas.constant.NumberConstant.GIFT_STANDARD;

import christmas.constant.MenuConstant;
import christmas.constant.PromotionConstant;

public class GiftPromotion {

    public Enum checkGiftQualified(int totalPrice) {
        if (GIFT_STANDARD.getNumber() <= totalPrice) {
            return MenuConstant.CHAMPAGNE;
        }
        return PromotionConstant.NOT_QUALIFIED;
    }
}
