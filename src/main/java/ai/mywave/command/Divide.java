package ai.mywave.command;

import ai.mywave.entity.Operation;

import java.math.BigDecimal;

public class Divide {
  private final Operation operation;

  public Divide(Operation operation) {
    this.operation = operation;
  }

  public BigDecimal execute() {
    return operation.getLeftOperand().divide(operation.getRightOperand());
  }
}
