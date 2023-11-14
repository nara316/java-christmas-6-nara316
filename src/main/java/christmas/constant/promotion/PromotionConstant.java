package christmas.constant.promotion;

import christmas.constant.MenuConstant;
import java.util.EnumMap;

public enum PromotionConstant {

    CHRISTMAS("크리스마스 디데이 할인"),
    SPECIAL("특별 할인"),
    WEEKDAY("평일 할인"),
    WEEKEND("주말 할인"),
    GIFT("증정 이벤트"),
    NOT_APPLIED("없음");

    private final String label;

    PromotionConstant(String label) {
        this.label = label;
    }

    public static String checkGiftQualified(EnumMap<PromotionConstant, Integer> promotionResult) {
        if (isGiftApplied(promotionResult)) {
            return MenuConstant.getGiftName() + " 1개";
        }
        return NOT_APPLIED.label;
    }

    public static boolean isGiftApplied(EnumMap<PromotionConstant, Integer> promotionResult) {
        return promotionResult.containsKey(GIFT);
    }

    public String getLabel() {
        return label;
    }
}
