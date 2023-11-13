package christmas.domain;

import static christmas.constant.PromotionConstant.NOT_QUALIFIED;

import christmas.constant.BadgeConstant;

public class Badge {

    private final String label;

    private Badge(int totalDiscount) {
        this.label = generateBadge(totalDiscount);
    }

    public static Badge from(int totalDiscount) {
        return new Badge(totalDiscount);
    }

    private String generateBadge(int totalDiscount) {
        BadgeConstant badgeConstant = BadgeConstant.calculateBadge(totalDiscount);

        if (badgeConstant == null) {
            return NOT_QUALIFIED.getLabel();
        }
        return badgeConstant.getLabel();
    }

    public String getLabel() {
        return label;
    }
}
