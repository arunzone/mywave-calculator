package ai.mywave;

import ai.mywave.command.Command;
import ai.mywave.command.CommandFactory;
import ai.mywave.output.ConsoleOutput;
import ai.mywave.parser.AlgebraicExpressionParser;

import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {
        ConsoleOutput consoleOutput = new ConsoleOutput();
        try {
            AlgebraicExpressionParser algebraicExpressionParser = new AlgebraicExpressionParser();
            Command command = new CommandFactory(algebraicExpressionParser).commandFor(args);
            BigDecimal result = command.execute();
            consoleOutput.log(result);
        } catch (Exception exception) {
            consoleOutput.error(exception.getMessage());
        }
    }
}
