package christmas.domain;

import static christmas.constant.NumberConstant.PROMOTION_NOT_APPLIED;
import static christmas.constant.NumberConstant.PROMOTION_STANDARD;

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
            applyPromotion(PromotionConstant.GIFT, () ->
                    GiftPromotion.from(totalOrderPrice.getTotalPrice()).getGiftDiscount());
            applyPromotion(PromotionConstant.CHRISTMAS, () ->
                    ChristmasPromotion.from(visitDate.getDate()).getChristmasDiscount());
            applyPromotion(PromotionConstant.SPECIAL, () ->
                    SpecialPromotion.from(visitDate.getDate()).getSpecialDiscount());
            applyPromotion(PromotionConstant.WEEKDAY, () ->
                    WeekdayPromotion.of(orderResult.getOrderResult(), visitDate.getDate()).getWeekdayDiscount());
            applyPromotion(PromotionConstant.WEEKEND, () ->
                    WeekendPromotion.of(orderResult.getOrderResult(), visitDate.getDate()).getWeekendDiscount());
        }
        applyNotQualified();
    }

    private void applyPromotion(PromotionConstant promotionConstant, DiscountCalculator discountCalculator) {
        int discountPrice = discountCalculator.calculateDiscount();
        if (discountPrice > PROMOTION_NOT_APPLIED.getNumber()) {
            promotionResult.put(promotionConstant, discountPrice);
        }
    }

    private void applyNotQualified() {
        if (promotionResult.isEmpty()) {
         promotionResult.put(PromotionConstant.NOT_APPLIED, PROMOTION_NOT_APPLIED.getNumber());
        }
    }

    public EnumMap<PromotionConstant, Integer> getPromotionResult() {
        return promotionResult;
    }

    @FunctionalInterface
    private interface DiscountCalculator {
        int calculateDiscount();
    }
}
