package christmas.domain;

import static christmas.constant.ExceptionConstant.VISIT_DATE_RANGE;
import static christmas.constant.NumberConstant.END_DATE;
import static christmas.constant.NumberConstant.START_DATE;

public class VisitDate {

    private final int date;

    private VisitDate(int date) {
        validateDateRange(date);
        this.date = date;
    }

    public static VisitDate from(int date) {
        return new VisitDate(date);
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
