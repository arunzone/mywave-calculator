package ai.mywave.command;

import ai.mywave.entity.Operation;

import java.math.BigDecimal;

public class Divide {
  public BigDecimal execute(Operation operation) {
    return operation.getLeftOperand().divide(operation.getRightOperand());
  }
}
