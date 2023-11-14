package christmas.controller;

import christmas.domain.OrderResult;
import christmas.domain.PromotionResult;
import christmas.domain.TotalOrderPrice;
import christmas.domain.VisitDate;
import christmas.service.PromotionService;
import christmas.service.OrderService;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.function.Supplier;

public class MainController {

    private final OrderService orderService;
    private final PromotionService promotionService;
    private final InputView inputView;
    private final OutputView outputView;

    public MainController(
            OrderService orderService, PromotionService promotionService,
            InputView inputView, OutputView outputView
    ) {
        this.orderService = orderService;
        this.promotionService = promotionService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        VisitDate visitDate = executeWithExceptionHandle(this::inputVisitDate);
        OrderResult orderResult = executeWithExceptionHandle(this::inputOrders);
        TotalOrderPrice totalOrderPrice = orderService.generateTotalPrice(orderResult);
        PromotionResult promotionResult = promotionService.generatePromotionResult(
                visitDate, totalOrderPrice, orderResult);

        printOrderInfo(visitDate, orderResult, totalOrderPrice);
        printPromotionInfo(promotionResult, totalOrderPrice);
    }

    private VisitDate inputVisitDate() {
        String userInput = inputView.inputVisitDate();
        return orderService.generateVisitDate(userInput);
    }

    private OrderResult inputOrders() {
        String userInput = inputView.inputOrders();
        return orderService.generateOrders(userInput);
    }

    private void printOrderInfo(VisitDate visitDate, OrderResult orderResult, TotalOrderPrice totalOrderPrice) {
        outputView.printOrderPreview(visitDate.getDate());
        outputView.printOrderMenu(orderResult.getOrderResult());
        outputView.printTotalOrderPrice(totalOrderPrice.getTotalPrice());
    }

    private void printPromotionInfo(PromotionResult promotionResult, TotalOrderPrice totalOrderPrice) {
        int totalDiscountPrice = promotionResult.calculateTotalDiscount();
        int totalDiscountWithoutGift =
                promotionResult.calculateTotalDiscountWithoutGift(promotionResult, totalDiscountPrice);
        int totalOrderPriceAfterDiscount =
                totalOrderPrice.calculateTotalOrderPriceAfterPromotion(totalDiscountWithoutGift);
        String badge = promotionService.generateBadge(totalDiscountPrice).getLabel();

        outputView.printGiftMenu(promotionResult.getPromotionResult());
        outputView.printBenefitsDetails(promotionResult.getPromotionResult());
        outputView.printTotalBenefitPrice(totalDiscountPrice);
        outputView.printTotalOrderPriceAfterBenefit(totalOrderPriceAfterDiscount);
        outputView.printEventBadge(badge);
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
