package time_measurement.exceptions;

public class CannotInvokeMethodException extends RuntimeException {

    public CannotInvokeMethodException(String msg) {
        super(msg);
    }

    public CannotInvokeMethodException() {
        super("This method cannot be invoked before another specific method of this class have been called");
    }
}
