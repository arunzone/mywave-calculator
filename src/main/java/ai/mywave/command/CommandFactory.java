package ai.mywave.command;

import ai.mywave.entity.Expression;
import ai.mywave.parser.AlgebraicExpressionParser;

import java.util.Map;
import java.util.function.Function;

import static java.util.Map.entry;

public class CommandFactory {
  private final AlgebraicExpressionParser algebraicExpressionParser;
  private final Map<String, Function<Expression, Command>> algebraicCommandRegistry = Map.ofEntries(
      entry("+", Add::new),
      entry("-", Subtract::new),
      entry("*", Multiply::new),
      entry("/", Divide::new)
  );

  public CommandFactory(AlgebraicExpressionParser algebraicExpressionParser) {
    this.algebraicExpressionParser = algebraicExpressionParser;
  }


  public Command commandFor(String[] arguments) {
    if (arguments.length == 3) {
      Expression expression = algebraicExpressionParser.operationFrom(arguments);
      return algebraicCommandRegistry.
          get(expression.getOperator()).
          apply(expression);
    }
    return () -> null;
  }
}
