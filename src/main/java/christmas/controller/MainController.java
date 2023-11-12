package christmas.controller;

import christmas.domain.Order;
import christmas.domain.OrderResult;
import christmas.domain.VisitDate;
import christmas.service.OrderService;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.function.Supplier;

public class MainController {

    private final OrderService orderService;
    private final InputView inputView;
    private final OutputView outputView;

    public MainController(OrderService orderService, InputView inputView, OutputView outputView) {
        this.orderService = orderService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        VisitDate visitDate = executeWithExceptionHandle(this::inputVisitDate);
        OrderResult orderResult = executeWithExceptionHandle(this::inputOrders);
        outputView.printDiscountPreview(visitDate.getDate());
        outputView.printOrderMenu(orderResult);
        outputView.printTotalOrderPrice(orderService.generateTotalPrice(orderResult));
    }

    private VisitDate inputVisitDate() {
            int date = inputView.inputVisitDate();
            return orderService.generateVisitDate(date);
    }

    private OrderResult inputOrders() {
            String userInput = inputView.inputOrders();
            return orderService.generateOrders(userInput);
    }

    private static <T> T executeWithExceptionHandle (final Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
