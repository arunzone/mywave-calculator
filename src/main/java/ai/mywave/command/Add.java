package ai.mywave.command;

import ai.mywave.entity.Operation;

import java.math.BigDecimal;

public class Add {
  private final Operation operation;

  public Add(Operation operation) {
    this.operation = operation;
  }

  public BigDecimal execute() {
    return operation.getLeftOperand().add(operation.getRightOperand());
  }
}
