package ai.mywave.interpreter;

import ai.mywave.entity.Operation;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

  @Test
  void shouldThrowExceptionOnInvalidLeftOperand(){
    OperationInterpreter operationInterpreter =  new OperationInterpreter();
    InvalidInputException invalidInputException = assertThrows(InvalidInputException.class, () -> {
      operationInterpreter.operationFrom(new String[]{"1ab", "+", "2"});
    });

    assertThat(invalidInputException.getMessage(), is("Invalid left operand: 1ab"));
  }

  @Test
  void shouldThrowExceptionOnInvalidRightOperand(){
    OperationInterpreter operationInterpreter =  new OperationInterpreter();
    InvalidInputException invalidInputException = assertThrows(InvalidInputException.class, () -> {
      operationInterpreter.operationFrom(new String[]{"1", "+", "2bc"});
    });

    assertThat(invalidInputException.getMessage(), is("Invalid right operand: 2bc"));
  }

  @Test
  void shouldThrowExceptionOnInvalidOperator() {
    OperationInterpreter operationInterpreter = new OperationInterpreter();
    InvalidInputException invalidInputException = assertThrows(InvalidInputException.class, () -> {
      operationInterpreter.operationFrom(new String[]{"1", "#", "2"});
    });

    assertThat(invalidInputException.getMessage(), is("Invalid operator: #"));
  }

  @Test
  void shouldThrowExceptionOnInvalidInput() {
    OperationInterpreter operationInterpreter = new OperationInterpreter();
    InvalidInputException invalidInputException = assertThrows(InvalidInputException.class, () -> {
      operationInterpreter.operationFrom(new String[]{"1", "#"});
    });

    assertThat(invalidInputException.getMessage(), is("Invalid input: 1 #"));
  }

}
