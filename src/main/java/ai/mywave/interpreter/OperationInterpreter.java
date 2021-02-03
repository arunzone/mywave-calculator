package ai.mywave.interpreter;

import ai.mywave.entity.Operation;

import java.math.BigDecimal;
import java.util.regex.Pattern;

public class OperationInterpreter {

  public static final Pattern OPERAND_PATTERN = Pattern.compile("^[0-9]+([.][0-9]+)?$");

  public Operation operationFrom(String[] arguments) {
    validateLeftOperand(arguments[0]);
    validateRightOperand(arguments[2]);
    return new Operation(
        new BigDecimal(arguments[0]),
        arguments[1],
        new BigDecimal(arguments[2]));
  }

  private void validateLeftOperand(String argument) {
    if(!OPERAND_PATTERN.matcher(argument).matches()){
      throw new InvalidInputException(String.format("Invalid left operand: %s", argument));
    }
  }
  private void validateRightOperand(String argument) {
    if(!OPERAND_PATTERN.matcher(argument).matches()){
      throw new InvalidInputException(String.format("Invalid right operand: %s", argument));
    }
  }
}
