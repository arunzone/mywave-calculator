package ai.mywave.parser;

import ai.mywave.entity.Operation;

import java.math.BigDecimal;
import java.util.regex.Pattern;

import static java.lang.String.join;

public class OperationParser {

  public static final Pattern OPERAND_PATTERN = Pattern.compile("^[0-9]+([.][0-9]+)?$");
  public static final Pattern OPERATOR_PATTERN = Pattern.compile("^([+\\-*/])$");

  public Operation operationFrom(String[] arguments) {
    validate(arguments);
    return new Operation(
        new BigDecimal(arguments[0]),
        arguments[1],
        new BigDecimal(arguments[2]));
  }

  private void validate(String[] arguments) {
    validateInput(arguments);
    validateLeftOperand(arguments[0]);
    validateRightOperand(arguments[2]);
    validateOperator(arguments[1]);
  }

  private void validateLeftOperand(String argument) {
    if (!OPERAND_PATTERN.matcher(argument).matches()) {
      throw new InvalidInputException(String.format("Invalid left operand: %s", argument));
    }
  }

  private void validateRightOperand(String argument) {
    if (!OPERAND_PATTERN.matcher(argument).matches()) {
      throw new InvalidInputException(String.format("Invalid right operand: %s", argument));
    }
  }

  private void validateOperator(String argument) {
    if (!OPERATOR_PATTERN.matcher(argument).matches()) {
      throw new InvalidInputException(String.format("Invalid operator: %s", argument));
    }
  }

  private void validateInput(String[] arguments) {
    if (arguments.length < 3) {
      String formattedArguments = join(" ", arguments);
      throw new InvalidInputException(String.format("Invalid input: %s", formattedArguments));
    }
  }

}
