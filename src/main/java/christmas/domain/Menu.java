package christmas.domain;

public class Menu {

    private final String name;

    private Menu(String name) {
        this.name = name;
    }

    public static Menu from(String name) {
        return new Menu(name);
    }
}
