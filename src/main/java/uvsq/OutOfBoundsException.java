package uvsq;

public class OutOfBoundsException extends Exception{

    public OutOfBoundsException() {
        super("Value is either superior to MAX_VALUE or inferior to MIN_VALUE");
    }


}