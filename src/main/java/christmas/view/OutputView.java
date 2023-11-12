package christmas.view;

import christmas.domain.OrderResult;
import christmas.domain.Orders;

public class OutputView {

    private static final String DISCOUNT_PREVIEW_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
    private static final String ORDER_MENU_MESSAGE = "<주문 메뉴>";
    private static final String TOTAL_ORDER_PRICE_MESSAGE = "<할인 전 총주문 금액>\n" + "%,d원\n";
    private static final String GIFT_MENU_MESSAGE = "<증정 메뉴>\n";
    private static final String BENEFITS_DETAILS_MESSAGE = "<혜택 내역>\n";
    private static final String TOTAL_BENEFIT_PRICE_MESSAGE = "<총혜택 금액>\n" + "%,d원\n";
    private static final String TOTAL_ORDER_PRICE_AFTER_BENEFIT_MESSAGE = "<할인 후 예상 결제 금액>\n" + "%,d원\n";
    private static final String EVENT_BADGE_MESSAGE = "<12월 이벤트 배지>\n";


    public void printDiscountPreview(int visitDate) {
        System.out.printf(DISCOUNT_PREVIEW_MESSAGE, visitDate);
    }

    public void printOrderMenu(OrderResult result) {
        System.out.println(ORDER_MENU_MESSAGE);
        result.getOrderResult().entrySet().stream()
                .forEach(entry -> {
                    System.out.println(entry.getKey().getName() + " " + entry.getValue() + "개");
                });
    }

    public void printTotalOrderPrice(int totalPrice) {
        System.out.printf(TOTAL_ORDER_PRICE_MESSAGE, totalPrice);
    }

    private void printGiftMenu() {
        System.out.println(GIFT_MENU_MESSAGE);
    }

    private void printBenefitsDetails() {
        System.out.println(BENEFITS_DETAILS_MESSAGE);
    }

    private void printTotalBenefitPrice() {
        System.out.println(TOTAL_BENEFIT_PRICE_MESSAGE);
    }

    private void printTotalOrderPriceAfterBenefit() {
        System.out.println(TOTAL_ORDER_PRICE_AFTER_BENEFIT_MESSAGE);
    }

    private void EVENT_BADGE_MESSAGE() {
        System.out.println(EVENT_BADGE_MESSAGE);
    }
}
