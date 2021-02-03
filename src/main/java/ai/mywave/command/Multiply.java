package ai.mywave.command;

import ai.mywave.entity.Operation;

import java.math.BigDecimal;

public class Multiply implements Command {
  public BigDecimal execute(Operation operation) {
    return operation.getLeftOperand().multiply(operation.getRightOperand());
  }
}
