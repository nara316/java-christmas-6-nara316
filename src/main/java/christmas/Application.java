package christmas;

import christmas.controller.MainController;
import christmas.service.DiscountService;
import christmas.service.OrderService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        MainController mainController = new MainController(
                new OrderService(),
                new DiscountService(),
                new InputView(),
                new OutputView()
        );
        mainController.run();
    }
}
