package ai.mywave.parser;

import ai.mywave.entity.Expression;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExpressionParserTest {
  @Test
  void shouldReturnValidOperation() {
    Expression sumExpression = new Expression(
        new BigDecimal("1"),
        "+",
        new BigDecimal("2")
    );
    AlgebraicExpressionParser algebraicExpressionParser = new AlgebraicExpressionParser();

    Expression expression = algebraicExpressionParser.operationFrom(new String[]{"1", "+", "2"});

    assertThat(expression, is(sumExpression));
  }

  @Test
  void shouldThrowExceptionOnInvalidLeftOperand(){
    AlgebraicExpressionParser algebraicExpressionParser = new AlgebraicExpressionParser();
    InvalidInputException invalidInputException = assertThrows(InvalidInputException.class, () -> {
      algebraicExpressionParser.operationFrom(new String[]{"1ab", "+", "2"});
    });

    assertThat(invalidInputException.getMessage(), is("Invalid left operand: 1ab"));
  }

  @Test
  void shouldThrowExceptionOnInvalidRightOperand(){
    AlgebraicExpressionParser algebraicExpressionParser = new AlgebraicExpressionParser();
    InvalidInputException invalidInputException = assertThrows(InvalidInputException.class, () -> {
      algebraicExpressionParser.operationFrom(new String[]{"1", "+", "2bc"});
    });

    assertThat(invalidInputException.getMessage(), is("Invalid right operand: 2bc"));
  }

  @Test
  void shouldThrowExceptionOnInvalidOperator() {
    AlgebraicExpressionParser algebraicExpressionParser = new AlgebraicExpressionParser();
    InvalidInputException invalidInputException = assertThrows(InvalidInputException.class, () -> {
      algebraicExpressionParser.operationFrom(new String[]{"1", "#", "2"});
    });

    assertThat(invalidInputException.getMessage(), is("Invalid operator: #"));
  }

  @Test
  void shouldThrowExceptionOnInvalidInput() {
    AlgebraicExpressionParser algebraicExpressionParser = new AlgebraicExpressionParser();
    InvalidInputException invalidInputException = assertThrows(InvalidInputException.class, () -> {
      algebraicExpressionParser.operationFrom(new String[]{"1", "#"});
    });

    assertThat(invalidInputException.getMessage(), is("Invalid input: 1 #"));
  }

}
