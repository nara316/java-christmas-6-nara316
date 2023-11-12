package christmas.constant;

import static christmas.constant.MenuConstant.CHAMPAGNE;

import christmas.domain.PromotionResult;

public enum PromotionConstant {

    CHRISTMAS("크리스마스 디데이 할인"),
    SPECIAL("특별 할인"),
    WEEKDAY("평일 할인"),
    WEEKEND("주말 할인"),
    GIFT("증정 이벤트"),
    NOT_QUALIFIED("없음");

    private final String label;

    PromotionConstant(String label) {
        this.label = label;
    }

    public static String checkGiftQualified(PromotionResult promotionResult) {
        if (promotionResult.getPromotionResult().containsKey(GIFT)) {
            return CHAMPAGNE.getName() + " 1개";
        }
        return NOT_QUALIFIED.label;
    }

    public String getLabel() {
        return label;
    }
}
