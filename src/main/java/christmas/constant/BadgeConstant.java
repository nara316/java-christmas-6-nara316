package christmas.constant;

public enum BadgeConstant {

    STAR("별", 5_000),
    TREE("트리", 10_000),
    SANTA("산타", 20_000);

    private final String label;
    private final int standard;

    BadgeConstant(String label, int standard) {
        this.label = label;
        this.standard = standard;
    }
}
