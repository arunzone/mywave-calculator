package ai.mywave.command;

import ai.mywave.entity.Operation;

import java.math.BigDecimal;

public interface Command {
  BigDecimal execute(Operation operation);
}
