package christmas.domain;

public class Quantity {

    private final int value;

    private Quantity(int value) {
        this.value = value;
    }

    public static Quantity from(int value) {
        return new Quantity(value);
    }
}
