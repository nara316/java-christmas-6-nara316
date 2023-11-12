package christmas.domain;

import christmas.constant.NumberConstant;
import christmas.constant.PromotionConstant;
import christmas.promotion.ChristmasPromotion;
import christmas.promotion.GiftPromotion;
import christmas.promotion.SpecialPromotion;
import christmas.promotion.WeekdayPromotion;
import christmas.promotion.WeekendPromotion;
import java.util.EnumMap;

public class PromotionResult {

    private final EnumMap<PromotionConstant, Integer> promotionResult;

    private PromotionResult(int date, int totalPrice, OrderResult orderResult) {
        this.promotionResult = generateTotalDiscount();
        applyAllPromotion(date, totalPrice, orderResult);
    }

    public static PromotionResult of(int date, int totalPrice, OrderResult orderResult) {
        return new PromotionResult(date, totalPrice, orderResult);
    }

    private EnumMap<PromotionConstant, Integer> generateTotalDiscount() {
        EnumMap<PromotionConstant, Integer> promotionResult = new EnumMap<>(PromotionConstant.class);
        return promotionResult;
    }

    private void applyAllPromotion(int date, int totalPrice, OrderResult orderResult) {
        applyGiftPromotion(totalPrice);
        applyChristmasPromotion(date);
        applySpecialPromotion(date);
        applyWeekdayPromotion(orderResult, date);
        applyWeekendPromotion(orderResult, date);
        applyNotQualified();
    }

    private void applyGiftPromotion(int totalPrice) {
        int giftSalePrice = GiftPromotion.from(totalPrice).getGiftDiscount();
        if (giftSalePrice > NumberConstant.PROMOTION_NOT_QUALIFIED.getNumber()) {
            promotionResult.put(PromotionConstant.GIFT, giftSalePrice);
        }
    }

    private void applyChristmasPromotion(int date) {
        int christmasSalePrice = ChristmasPromotion.from(date).getChristmasDiscount();
        if (christmasSalePrice > NumberConstant.PROMOTION_NOT_QUALIFIED.getNumber()) {
            promotionResult.put(PromotionConstant.CHRISTMAS, christmasSalePrice);
        }
    }

    private void applySpecialPromotion(int date) {
        int specialSalePrice = SpecialPromotion.from(date).getSpecialDiscount();
        if (specialSalePrice > NumberConstant.PROMOTION_NOT_QUALIFIED.getNumber()) {
            promotionResult.put(PromotionConstant.SPECIAL, specialSalePrice);
        }
    }

    private void applyWeekdayPromotion(OrderResult orderResult, int date) {
        int weekdaySalePrice = WeekdayPromotion.of(orderResult.getOrderResult(), date).getWeekdayDiscount();
        if (weekdaySalePrice > NumberConstant.PROMOTION_NOT_QUALIFIED.getNumber()) {
            promotionResult.put(PromotionConstant.WEEKDAY, weekdaySalePrice);
        }
    }

    private void applyWeekendPromotion(OrderResult orderResult, int date) {
        int weekendSalePrice = WeekendPromotion.of(orderResult.getOrderResult(), date).getWeekendDiscount();
        if (weekendSalePrice > NumberConstant.PROMOTION_NOT_QUALIFIED.getNumber()) {
            promotionResult.put(PromotionConstant.WEEKEND, weekendSalePrice);
        }
    }

    private void applyNotQualified() {
        if (promotionResult.isEmpty()) {
         promotionResult.put(PromotionConstant.NOT_QUALIFIED, NumberConstant.PROMOTION_NOT_QUALIFIED.getNumber());
        }
    }

    public int calculateTotalDiscount() {
        return promotionResult.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public EnumMap<PromotionConstant, Integer> getPromotionResult() {
        return promotionResult;
    }
}
