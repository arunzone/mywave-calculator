package ai.mywave;

import ai.mywave.command.Command;
import ai.mywave.command.CommandFactory;
import ai.mywave.entity.Operation;
import ai.mywave.interpreter.OperationInterpreter;
import ai.mywave.output.ConsoleOutput;

import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {
        Operation operation = new OperationInterpreter().operationFrom(args);
        Command command = new CommandFactory().commandFor(operation);
        BigDecimal result = command.execute(operation);
        new ConsoleOutput().log(result);
    }
}
