package ai.mywave.command;

import ai.mywave.entity.Operation;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class MultiplyTest {
  @Test
  void shouldReturnMultiplicationResult() {
    Operation operation = new Operation(
        new BigDecimal("3.0"),
        "*",
        new BigDecimal("2")
    );

    Multiply multiply = new Multiply();

    BigDecimal result = multiply.execute(operation);

    assertThat(result, is(new BigDecimal("6.0")));
  }

}
