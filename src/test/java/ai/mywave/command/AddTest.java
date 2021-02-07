package ai.mywave.command;


import ai.mywave.entity.Expression;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AddTest {
  @Test
  public void shouldReturnSumResult() {
    Expression expression = new Expression(
        new BigDecimal("2.0"),
        "+",
        new BigDecimal("3")
    );
    Add add = new Add(expression);

    BigDecimal result = add.execute();

    assertThat(result, is(new BigDecimal("5.0")));
  }
}
