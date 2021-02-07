package ai.mywave.command;

import ai.mywave.entity.Expression;

import java.math.BigDecimal;

public class Add implements Command {
  private final Expression expression;

  public Add(Expression expression) {
    this.expression = expression;
  }

  @Override
  public BigDecimal execute() {
    return expression.getLeftOperand().add(expression.getRightOperand());
  }
}
