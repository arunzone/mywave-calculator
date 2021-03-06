package ai.mywave.output;


import static java.lang.String.format;

public class ConsoleOutput {
  public <T> void log(T content) {
    System.out.println(format("Result is %s", content));
  }

  public void error(String message) {
    System.err.println(message);
    System.out.println("Accepted input format: <Operand> <Operator> <Operand>");
    System.out.println("example: 1.5 + 2.5");
  }
}
