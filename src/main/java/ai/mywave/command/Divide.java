package ai.mywave.command;

import ai.mywave.entity.Expression;

import java.math.BigDecimal;

public class Divide implements Command {
  private final Expression expression;

  public Divide(Expression expression) {
    this.expression = expression;
  }

  @Override
  public BigDecimal execute() {
    return expression.getLeftOperand().divide(expression.getRightOperand());
  }
}
