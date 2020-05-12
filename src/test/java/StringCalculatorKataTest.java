import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorKataTest {
    private StringCalculatorKata stringCalculatorKata;

    @BeforeEach
    void setup() {
        stringCalculatorKata = new StringCalculatorKata();
    }

    @Test
    public void shouldReturnZeroWhenGotEmptyString() {
        int result = stringCalculatorKata.add("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void shouldReturnNumberWhenGotNumber() {
        int result = stringCalculatorKata.add("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldAddTwoNumbersSeparatedWithComma() {
        int result = stringCalculatorKata.add("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void shouldAddThreeNumbersSeparatedWithComma() {
        int result = stringCalculatorKata.add("1,2,3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void shouldAddThreeNumbersSeparatedWithCommaAndNewLine() {
        int result = stringCalculatorKata.add("1,2\n4");
        assertThat(result).isEqualTo(7);
    }

    @Test
    void shouldThrowExceptionWhenNegativeNumberProvided() {
        Assertions.assertThrows(NegativeNumberException.class, () -> {
            stringCalculatorKata.add("-1");
        });
    }

    @Test
    void shouldIncludeAllNegativeNumbersInExceptionMessage() {
        NegativeNumberException exception=Assertions.assertThrows(NegativeNumberException.class, () -> {
            stringCalculatorKata.add("-1,-2");
        });
        assertThat(exception.getMessage()).isEqualTo("Negatives: -1 -2");
    }


}
