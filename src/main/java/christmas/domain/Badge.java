package christmas.domain;

import static christmas.constant.PromotionConstant.NOT_QUALIFIED;

import christmas.constant.BadgeConstant;

public class Badge {

    private final String name;

    private Badge(int totalDiscount) {
        this.name = generateBadge(totalDiscount);
    }

    public static Badge from(int totalDiscount) {
        return new Badge(totalDiscount);
    }

    private String generateBadge(int totalPrice) {
        BadgeConstant badgeConstant = BadgeConstant.calculateBadge(totalPrice);
        if (badgeConstant == null) {
            return NOT_QUALIFIED.getLabel();
        }
        return badgeConstant.getLabel();
    }

    public String getName() {
        return name;
    }
}
