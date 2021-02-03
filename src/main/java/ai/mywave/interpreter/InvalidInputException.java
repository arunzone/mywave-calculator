package ai.mywave.interpreter;

public class InvalidInputException extends RuntimeException{
  public InvalidInputException(String message){
    super(message);
  }
}
