package ai.mywave.command;

import ai.mywave.entity.Operation;

import java.util.Map;

import static java.util.Map.entry;

public class CommandFactory {
  private final Map<String, Command> commandRegistry = Map.ofEntries(
      entry("+", new Add()),
      entry("-", new Subtract()),
      entry("*", new Multiply()),
      entry("/", new Divide())
  );


  public Command commandFor(Operation operation) {
    return commandRegistry.get(operation.getOperator());
  }
}
