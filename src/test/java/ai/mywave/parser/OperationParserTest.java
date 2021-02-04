package ai.mywave.parser;

import ai.mywave.entity.Operation;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OperationParserTest {
  @Test
  void shouldReturnValidOperation(){
    Operation sumOperation = new Operation(
        new BigDecimal("1"),
        "+",
        new BigDecimal("2")
    );
    OperationParser operationParser =  new OperationParser();

    Operation operation = operationParser.operationFrom(new String[]{"1", "+", "2"});

    assertThat(operation, is(sumOperation));
  }

  @Test
  void shouldThrowExceptionOnInvalidLeftOperand(){
    OperationParser operationParser =  new OperationParser();
    InvalidInputException invalidInputException = assertThrows(InvalidInputException.class, () -> {
      operationParser.operationFrom(new String[]{"1ab", "+", "2"});
    });

    assertThat(invalidInputException.getMessage(), is("Invalid left operand: 1ab"));
  }

  @Test
  void shouldThrowExceptionOnInvalidRightOperand(){
    OperationParser operationParser =  new OperationParser();
    InvalidInputException invalidInputException = assertThrows(InvalidInputException.class, () -> {
      operationParser.operationFrom(new String[]{"1", "+", "2bc"});
    });

    assertThat(invalidInputException.getMessage(), is("Invalid right operand: 2bc"));
  }

  @Test
  void shouldThrowExceptionOnInvalidOperator() {
    OperationParser operationParser = new OperationParser();
    InvalidInputException invalidInputException = assertThrows(InvalidInputException.class, () -> {
      operationParser.operationFrom(new String[]{"1", "#", "2"});
    });

    assertThat(invalidInputException.getMessage(), is("Invalid operator: #"));
  }

  @Test
  void shouldThrowExceptionOnInvalidInput() {
    OperationParser operationParser = new OperationParser();
    InvalidInputException invalidInputException = assertThrows(InvalidInputException.class, () -> {
      operationParser.operationFrom(new String[]{"1", "#"});
    });

    assertThat(invalidInputException.getMessage(), is("Invalid input: 1 #"));
  }

}
