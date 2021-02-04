package ai.mywave.command;

import ai.mywave.entity.Operation;

import java.math.BigDecimal;

public class Subtract implements Command {
  @Override
  public BigDecimal execute(Operation operation) {
    return operation.getLeftOperand().subtract(operation.getRightOperand());
  }
}
