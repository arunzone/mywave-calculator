package ai.mywave.command;


import ai.mywave.entity.Operation;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AddTest {
  @Test
  public void shouldReturnSumResult() {
    Operation operation = new Operation(
        new BigDecimal("2.0"),
        '+',
        new BigDecimal("3")
    );
    Add add = new Add();

    BigDecimal result = add.execute(operation);

    assertThat(result, is(new BigDecimal("5.0")));
  }
}
