package ai.mywave.command;

import ai.mywave.entity.Expression;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class SubtractTest {
  @Test
  void shouldReturnSubtractionResult() {
    Expression expression = new Expression(
        new BigDecimal("3.0"),
        "-",
        new BigDecimal("2")
    );

    Subtract subtract = new Subtract(expression);

    BigDecimal result = subtract.execute();

    assertThat(result, is(new BigDecimal("1.0")));
  }

}
