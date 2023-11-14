package christmas.domain;

import static christmas.constant.NumberConstant.PROMOTION_STANDARD;

import christmas.constant.MenuConstant;
import christmas.constant.NumberConstant;
import christmas.constant.promotion.PromotionConstant;
import christmas.domain.promotion.ChristmasPromotion;
import christmas.domain.promotion.GiftPromotion;
import christmas.domain.promotion.SpecialPromotion;
import christmas.domain.promotion.WeekdayPromotion;
import christmas.domain.promotion.WeekendPromotion;
import java.util.EnumMap;

public class PromotionResult {

    private final EnumMap<PromotionConstant, Integer> promotionResult;

    private PromotionResult(VisitDate visitDate, TotalOrderPrice totalOrderPrice, OrderResult orderResult) {
        this.promotionResult = generateTotalDiscount();
        applyAllPromotion(visitDate, totalOrderPrice, orderResult);
    }

    public static PromotionResult of(VisitDate visitDate, TotalOrderPrice totalOrderPrice, OrderResult orderResult) {
        return new PromotionResult(visitDate, totalOrderPrice, orderResult);
    }

    private EnumMap<PromotionConstant, Integer> generateTotalDiscount() {
        EnumMap<PromotionConstant, Integer> promotionResult = new EnumMap<>(PromotionConstant.class);
        return promotionResult;
    }

    private void applyAllPromotion(VisitDate visitDate, TotalOrderPrice totalOrderPrice, OrderResult orderResult) {
        if (PROMOTION_STANDARD.getNumber() <= totalOrderPrice.getTotalPrice()) {
            applyGiftPromotion(totalOrderPrice.getTotalPrice());
            applyChristmasPromotion(visitDate.getDate());
            applySpecialPromotion(visitDate.getDate());
            applyWeekdayPromotion(orderResult, visitDate.getDate());
            applyWeekendPromotion(orderResult, visitDate.getDate());
        }
        applyNotQualified();
    }

    private void applyGiftPromotion(int totalOrderPrice) {
        int giftSalePrice = GiftPromotion.from(totalOrderPrice).getGiftDiscount();
        if (giftSalePrice > NumberConstant.PROMOTION_NOT_APPLIED.getNumber()) {
            promotionResult.put(PromotionConstant.GIFT, giftSalePrice);
        }
    }

    private void applyChristmasPromotion(int visitDate) {
        int christmasSalePrice = ChristmasPromotion.from(visitDate).getChristmasDiscount();
        if (christmasSalePrice > NumberConstant.PROMOTION_NOT_APPLIED.getNumber()) {
            promotionResult.put(PromotionConstant.CHRISTMAS, christmasSalePrice);
        }
    }

    private void applySpecialPromotion(int visitDate) {
        int specialSalePrice = SpecialPromotion.from(visitDate).getSpecialDiscount();
        if (specialSalePrice > NumberConstant.PROMOTION_NOT_APPLIED.getNumber()) {
            promotionResult.put(PromotionConstant.SPECIAL, specialSalePrice);
        }
    }

    private void applyWeekdayPromotion(OrderResult orderResult, int visitDate) {
        int weekdaySalePrice = WeekdayPromotion.of(orderResult.getOrderResult(), visitDate).getWeekdayDiscount();
        if (weekdaySalePrice > NumberConstant.PROMOTION_NOT_APPLIED.getNumber()) {
            promotionResult.put(PromotionConstant.WEEKDAY, weekdaySalePrice);
        }
    }

    private void applyWeekendPromotion(OrderResult orderResult, int visitDate) {
        int weekendSalePrice = WeekendPromotion.of(orderResult.getOrderResult(), visitDate).getWeekendDiscount();
        if (weekendSalePrice > NumberConstant.PROMOTION_NOT_APPLIED.getNumber()) {
            promotionResult.put(PromotionConstant.WEEKEND, weekendSalePrice);
        }
    }

    private void applyNotQualified() {
        if (promotionResult.isEmpty()) {
         promotionResult.put(PromotionConstant.NOT_APPLIED, NumberConstant.PROMOTION_NOT_APPLIED.getNumber());
        }
    }

    public int calculateTotalDiscount() {
        return promotionResult.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int calculateTotalDiscountWithoutGift(PromotionResult promotionResult, int totalDiscountPrice) {
        if (PromotionConstant.isGiftApplied(promotionResult.getPromotionResult())) {
            return totalDiscountPrice - MenuConstant.getGiftPrice();
        }
        return totalDiscountPrice;
    }

    public EnumMap<PromotionConstant, Integer> getPromotionResult() {
        return promotionResult;
    }
}
