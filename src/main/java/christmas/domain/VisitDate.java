package christmas.domain;

import static christmas.constant.ExceptionConstant.VISIT_DATE_RANGE;
import static christmas.constant.NumberConstant.END_DATE;
import static christmas.constant.NumberConstant.START_DATE;

import christmas.converter.StringConverter;

public class VisitDate {

    private final int date;

    private VisitDate(String userInput) {
        int visitdate = StringConverter.strToInt(userInput, VISIT_DATE_RANGE.getMessage());
        validateDateRange(visitdate);
        this.date = visitdate;
    }

    public static VisitDate from(String userInput) {
        return new VisitDate(userInput);
    }

    private void validateDateRange(int date) {
        if (date < START_DATE.getNumber() || END_DATE.getNumber() < date) {
            throw new IllegalArgumentException(VISIT_DATE_RANGE.getMessage());
        }
    }

    public int getDate() {
        return date;
    }
}
