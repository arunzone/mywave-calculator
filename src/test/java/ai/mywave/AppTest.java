package ai.mywave;


import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemErr;
import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AppTest {

  @Test
  public void shouldPrintCalculatedResultInConsole() throws Exception {
    String text = tapSystemOut(() -> {
      new App().main(new String[]{"5", "+", "7"});
    });

    assertThat(text, is("Result is 12\n"));
  }

  @Test
  public void shouldHandleInvalidInputAndPrintError() throws Exception {
    String text = tapSystemErr(() -> {
      App.main(new String[]{"5", "6", "7"});
    });

    assertThat(text, is("Invalid operator: 6\n"));
  }
}
