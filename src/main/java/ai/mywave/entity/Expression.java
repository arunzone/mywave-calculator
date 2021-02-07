package ai.mywave.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Expression {
  private BigDecimal rightOperand;
  private BigDecimal leftOperand;
  private String operator;

  public Expression(BigDecimal leftOperand, String operator, BigDecimal rightOperand) {
    this.leftOperand = leftOperand;
    this.operator = operator;
    this.rightOperand = rightOperand;
  }
}
