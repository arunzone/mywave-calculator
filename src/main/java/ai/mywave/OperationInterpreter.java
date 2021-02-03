package ai.mywave;

import ai.mywave.entity.Operation;

import java.math.BigDecimal;

public class OperationInterpreter {
  public Operation operationFrom(String[] arguments) {
    return new Operation(
        new BigDecimal(arguments[0]),
        arguments[1],
        new BigDecimal(arguments[2]));
  }
}
