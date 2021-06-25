package _15_exception.excercise;

public class IllegalTriangleException extends Exception {
//    private String message;
    public IllegalTriangleException(String message) {
      super(message);
    }
}
