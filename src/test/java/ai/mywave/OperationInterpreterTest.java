package ai.mywave;

import ai.mywave.entity.Operation;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class OperationInterpreterTest {
  @Test
  void shouldReturnValidOperation(){
    Operation sumOperation = new Operation(
        new BigDecimal("1"),
        "+",
        new BigDecimal("2")
    );
    OperationInterpreter operationInterpreter =  new OperationInterpreter();

    Operation operation = operationInterpreter.operationFrom(new String[]{"1", "+", "2"});

    assertThat(operation, is(sumOperation));
  }

}
