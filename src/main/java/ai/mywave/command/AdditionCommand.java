package ai.mywave.command;

import ai.mywave.entity.Operation;

import java.math.BigDecimal;

public class AdditionCommand {
  private final Operation operation;

  public AdditionCommand(Operation operation) {
    this.operation = operation;
  }

  public BigDecimal execute() {
    return operation.getLeftOperand().add(operation.getRightOperand());
  }
}
