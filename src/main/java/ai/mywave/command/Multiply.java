package ai.mywave.command;

import ai.mywave.entity.Operation;

import java.math.BigDecimal;

public class Multiply {
  private final Operation operation;

  public Multiply(Operation operation) {
    this.operation = operation;
  }

  public BigDecimal execute() {
    return operation.getLeftOperand().multiply(operation.getRightOperand());
  }
}
