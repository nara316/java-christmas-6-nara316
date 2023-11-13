package christmas.controller;

import christmas.domain.OrderResult;
import christmas.domain.PromotionResult;
import christmas.domain.VisitDate;
import christmas.service.DiscountService;
import christmas.service.OrderService;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.function.Supplier;

public class MainController {

    private final OrderService orderService;
    private final DiscountService discountService;
    private final InputView inputView;
    private final OutputView outputView;

    public MainController(
            OrderService orderService, DiscountService discountService,
            InputView inputView, OutputView outputView
    ) {
        this.orderService = orderService;
        this.discountService = discountService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        VisitDate visitDate = executeWithExceptionHandle(this::inputVisitDate);
        OrderResult orderResult = executeWithExceptionHandle(this::inputOrders);
        outputView.printDiscountPreview(visitDate.getDate());
        outputView.printOrderMenu(orderResult);
        int totalPrice = orderService.generateTotalPrice(orderResult);
        outputView.printTotalOrderPrice(totalPrice);
        PromotionResult promotionResult = discountService.generatePromotionResult(visitDate.getDate(), totalPrice, orderResult);
        outputView.printGiftMenu(promotionResult);
        outputView.printBenefitsDetails(promotionResult);
        int totalDiscountPrice = discountService.calculateTotalDiscount(promotionResult);
        outputView.printTotalBenefitPrice(totalDiscountPrice);
        outputView.printTotalOrderPriceAfterBenefit(promotionResult, totalPrice);
        outputView.printEventBadge(totalDiscountPrice);
    }

    private VisitDate inputVisitDate() {
        String userInput = inputView.inputVisitDate();
        return orderService.generateVisitDate(userInput);
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
