package uvsq;

public class DivisionZeroException extends Exception {

  public DivisionZeroException() {

    super("Cannot divide by zero");
  }
}
