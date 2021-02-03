package ai.mywave.interpreter;

import ai.mywave.entity.Operation;

import java.math.BigDecimal;

public class OperationInterpreter {
  public Operation operationFrom(String[] arguments) {
    validateLeftOperand(arguments[0]);
    return new Operation(
        new BigDecimal(arguments[0]),
        arguments[1],
        new BigDecimal(arguments[2]));
  }

  private void validateLeftOperand(String argument) {
    if(!argument.matches("^[0-9]+([.][0-9]+)?$")){
      throw new InvalidInputException(String.format("Invalid left operand: %s", argument));
    }
  }
}
