package ai.mywave.output;


import static java.lang.String.format;

public class ConsoleOutput {
  public <T> void log(T content) {
    System.out.println(format("Result is %s", content));
  }

  public void error(String message) {
    System.err.println(message);
  }
}
