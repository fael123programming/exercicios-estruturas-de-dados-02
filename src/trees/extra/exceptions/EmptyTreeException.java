package trees.extra.exceptions;

public class EmptyTreeException extends RuntimeException {
    public EmptyTreeException() {
        super("This tree is empty");
    }
}
