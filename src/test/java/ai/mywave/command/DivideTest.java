package ai.mywave.command;

import ai.mywave.entity.Expression;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class DivideTest {

  @Test
  void shouldReturnDivisionResult() {
    Expression expression = new Expression(
        new BigDecimal("6.0"),
        "/",
        new BigDecimal("3")
    );
    Divide divide = new Divide(expression);

    BigDecimal result = divide.execute();

    assertThat(result, is(new BigDecimal("2.0")));
  }
}
