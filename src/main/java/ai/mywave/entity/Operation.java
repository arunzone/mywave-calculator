package ai.mywave.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Operation {
  private BigDecimal rightOperand;
  private BigDecimal leftOperand;
  private String operator;

  public Operation(BigDecimal leftOperand, String operator, BigDecimal rightOperand) {
    this.leftOperand = leftOperand;
    this.operator = operator;
    this.rightOperand = rightOperand;
  }
}
