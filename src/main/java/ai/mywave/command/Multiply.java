package ai.mywave.command;

import ai.mywave.entity.Expression;

import java.math.BigDecimal;

public class Multiply implements Command {
  private final Expression expression;

  public Multiply(Expression expression) {
    this.expression = expression;
  }

  @Override
  public BigDecimal execute() {
    return expression.getLeftOperand().multiply(expression.getRightOperand());
  }
}
