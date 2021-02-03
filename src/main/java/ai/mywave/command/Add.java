package ai.mywave.command;

import ai.mywave.entity.Operation;

import java.math.BigDecimal;

public class Add implements Command {
  public BigDecimal execute(Operation operation) {
    return operation.getLeftOperand().add(operation.getRightOperand());
  }
}
