package ai.mywave.command;

import ai.mywave.entity.Expression;
import ai.mywave.parser.AlgebraicExpressionParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CommandFactoryTest {

  private CommandFactory commandFactory;

  @Mock
  Expression expression;
  @Mock
  AlgebraicExpressionParser algebraicExpressionParser;

  @BeforeEach
  void setup() {
    MockitoAnnotations.openMocks(this);
    when(algebraicExpressionParser.operationFrom(any())).thenReturn(expression);
    commandFactory = new CommandFactory(algebraicExpressionParser);
  }

  @Test
  void shouldReturnAddCommand() {
    String[] input = {"3.0", "+", "2"};
    when(expression.getOperator()).thenReturn("+");

    Command command = commandFactory.commandFor(input);

    assertThat(command.getClass(), is(equalTo(Add.class)));
  }

  @Test
  void shouldReturnSubtractCommand() {
    String[] input = {"3.0", "-", "2"};
    when(expression.getOperator()).thenReturn("-");

    Command command = commandFactory.commandFor(input);

    assertThat(command.getClass(), is(equalTo(Subtract.class)));
  }

  @Test
  void shouldReturnMultiplyCommand() {
    String[] input = {"3.0", "*", "2"};
    when(expression.getOperator()).thenReturn("*");
    Command command = commandFactory.commandFor(input);

    assertThat(command.getClass(), is(equalTo(Multiply.class)));
  }

  @Test
  void shouldReturnDivideCommand() {
    String[] input = {"3.0", "/", "2"};
    when(expression.getOperator()).thenReturn("/");

    Command command = commandFactory.commandFor(input);

    assertThat(command.getClass(), is(equalTo(Divide.class)));
  }

  @Test
  void shouldReturnSafeCommand() {
    String[] input = {"3.0"};

    Command command = commandFactory.commandFor(input);

    assertThat(command, is(notNullValue()));
  }
}
