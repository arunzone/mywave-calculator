package ai.mywave.output;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemErr;
import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class ConsoleOutputTest {

  @Test
  void shouldDisplayContentInConsole() throws Exception {
    String text = tapSystemOut(() -> {
      new ConsoleOutput().log(new BigDecimal("5"));
    });

    assertThat(text, is("Result is 5\n"));
  }

  @Test
  void shouldDisplayErrorInConsole() throws Exception {
    String text = tapSystemErr(() -> {
      new ConsoleOutput().error("Error message");
    });

    assertThat(text, is("Error message\n"));
  }

  @Test
  void shouldDisplayHelpMessageOnError() throws Exception {
    String text = tapSystemOut(() -> {
      new ConsoleOutput().error("Error message");
    });

    assertThat(text, is("Accepted input format: <Operand> <Operator> <Operand>\nexample: 1.5 + 2.5\n"));
  }

}
