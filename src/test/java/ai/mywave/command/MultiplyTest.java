package ai.mywave.command;

import ai.mywave.entity.Operation;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class MultiplyTest {
  @Test
  void shouldReturnSubtractionResult() {
    Operation operation = new Operation(
        new BigDecimal("3.0"),
        '*',
        new BigDecimal("2")
    );

    Multiply multiply = new Multiply(operation);

    BigDecimal result = multiply.execute();

    assertThat(result, is(new BigDecimal("6.0")));
  }

}
