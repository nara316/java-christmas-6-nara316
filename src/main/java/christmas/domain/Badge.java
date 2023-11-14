package christmas.domain;

import static christmas.constant.promotion.PromotionConstant.NOT_APPLIED;

import christmas.constant.promotion.BadgeConstant;

public class Badge {

    private final String label;

    private Badge(int totalDiscountPrice) {
        this.label = generateBadge(totalDiscountPrice);
    }

    public static Badge from(int totalDiscountPrice) {
        return new Badge(totalDiscountPrice);
    }

    private String generateBadge(int totalDiscountPrice) {
        return BadgeConstant.calculateBadge(totalDiscountPrice)
                .map(BadgeConstant::getLabel)
                .orElse(NOT_APPLIED.getLabel());
    }

    public String getLabel() {
        return label;
    }
}
