package christmas.constant.promotion;

import java.util.Arrays;
import java.util.Optional;

public enum BadgeConstant {

    SANTA("산타", 20_000),
    TREE("트리", 10_000),
    STAR("별", 5_000);

    private final String label;
    private final int standard;

    BadgeConstant(String label, int standard) {
        this.label = label;
        this.standard = standard;
    }

    public String getLabel() {
        return label;
    }

    public static Optional<BadgeConstant> calculateBadge(int totalDiscountPrice) {
        return Arrays.stream(values())
                .filter(badgeConstant -> totalDiscountPrice >= badgeConstant.standard)
                .findFirst();
    }
}
