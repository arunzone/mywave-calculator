package ai.mywave.command;

import ai.mywave.entity.Expression;

import java.math.BigDecimal;

public class Subtract implements Command {
  private final Expression expression;

  public Subtract(Expression expression) {
    this.expression = expression;
  }

  @Override
  public BigDecimal execute() {
    return expression.getLeftOperand().subtract(expression.getRightOperand());
  }
}
