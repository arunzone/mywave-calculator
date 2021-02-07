package ai.mywave.command;

import ai.mywave.entity.Expression;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class MultiplyTest {
  @Test
  void shouldReturnMultiplicationResult() {
    Expression expression = new Expression(
        new BigDecimal("3.0"),
        "*",
        new BigDecimal("2")
    );

    Multiply multiply = new Multiply(expression);

    BigDecimal result = multiply.execute();

    assertThat(result, is(new BigDecimal("6.0")));
  }

}
