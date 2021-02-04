package ai.mywave;

import ai.mywave.command.Command;
import ai.mywave.command.CommandFactory;
import ai.mywave.entity.Operation;
import ai.mywave.parser.OperationParser;
import ai.mywave.output.ConsoleOutput;

import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {
        ConsoleOutput consoleOutput = new ConsoleOutput();
        try {
            Operation operation = new OperationParser().operationFrom(args);
            Command command = new CommandFactory().commandFor(operation);
            BigDecimal result = command.execute(operation);
            consoleOutput.log(result);
        } catch (Exception exception) {
            consoleOutput.error(exception.getMessage());
        }
    }
}
