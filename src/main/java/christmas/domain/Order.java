package christmas.domain;

public class Order {

    private final Menu menu;
    private final Quantity quantity;

    private Order(String menu, int quantity) {
        this.menu = Menu.from(menu);
        this.quantity = Quantity.from(quantity);
    }

    public static Order of(String menu, int quantity) {
        return new Order(menu, quantity);
    }

    public Menu getMenu() {
        return menu;
    }

    public Quantity getQuantity() {
        return quantity;
    }
}
