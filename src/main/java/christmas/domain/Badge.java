package christmas.domain;

import static christmas.constant.promotion.PromotionConstant.NOT_QUALIFIED;

import christmas.constant.promotion.BadgeConstant;

public class Badge {

    private final String label;

    private Badge(int totalDiscount) {
        this.label = generateBadge(totalDiscount);
    }

    public static Badge from(int totalDiscount) {
        return new Badge(totalDiscount);
    }

    private String generateBadge(int totalDiscount) {
        return BadgeConstant.calculateBadge(totalDiscount)
                .map(BadgeConstant::getLabel)
                .orElse(NOT_QUALIFIED.getLabel());
    }

    public String getLabel() {
        return label;
    }
}
