package christmas.constant;

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
}
