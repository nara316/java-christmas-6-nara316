package christmas.domain;

import static christmas.constant.ExceptionConstant.VISIT_DATE_RANGE;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class VisitDateTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -999})
    void 방문날짜가_1_미만일_경우_예외발생(int date) {
        assertThatThrownBy(() -> VisitDate.from(date))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(VISIT_DATE_RANGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {32, 35, 888})
    void 방문날짜가_31_초과할_경우_예외발생(int date) {
        assertThatThrownBy(() -> VisitDate.from(date))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(VISIT_DATE_RANGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 16, 31})
    void 값이_유효하면_예외가_발생하지_않음(int date) {
        assertThatCode(() -> VisitDate.from(date))
                .doesNotThrowAnyException();
    }
}