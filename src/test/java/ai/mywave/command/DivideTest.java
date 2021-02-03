package ai.mywave.command;

import ai.mywave.entity.Operation;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class DivideTest {

  @Test
  void shouldReturnDivisionResult() {
    Operation operation = new Operation(
        new BigDecimal("6.0"),
        '/',
        new BigDecimal("3")
    );
    Divide divide = new Divide();

    BigDecimal result = divide.execute(operation);

    assertThat(result, is(new BigDecimal("2.0")));
  }
}
