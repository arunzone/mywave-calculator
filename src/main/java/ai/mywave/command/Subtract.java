package ai.mywave.command;

import ai.mywave.entity.Operation;

import java.math.BigDecimal;

public class Subtract {
  private final Operation operation;

  public Subtract(Operation operation) {
    this.operation = operation;
  }

  public BigDecimal execute() {
    return operation.getLeftOperand().subtract(operation.getRightOperand());
  }
}
