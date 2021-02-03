package ai.mywave.command;

import ai.mywave.entity.Operation;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;

class CommandFactoryTest {

  private CommandFactory commandFactory = new CommandFactory();

  @Test
  void shouldReturnAddCommand() {
    Operation operation = new Operation(
        new BigDecimal("3.0"),
        "+",
        new BigDecimal("2")
    );

    Command command = commandFactory.commandFor(operation);

    assertThat(command.getClass(), is(equalTo(Add.class)));
  }

  @Test
  void shouldReturnSubtractCommand() {
    Operation operation = new Operation(
        new BigDecimal("3.0"),
        "-",
        new BigDecimal("2")
    );

    Command command = commandFactory.commandFor(operation);

    assertThat(command.getClass(), is(equalTo(Subtract.class)));
  }

  @Test
  void shouldReturnMultiplyCommand() {
    Operation operation = new Operation(
        new BigDecimal("3.0"),
        "*",
        new BigDecimal("2")
    );

    Command command = commandFactory.commandFor(operation);

    assertThat(command.getClass(), is(equalTo(Multiply.class)));
  }

  @Test
  void shouldReturnDivideCommand() {
    Operation operation = new Operation(
        new BigDecimal("3.0"),
        "/",
        new BigDecimal("2")
    );

    Command command = commandFactory.commandFor(operation);

    assertThat(command.getClass(), is(equalTo(Divide.class)));
  }
}
