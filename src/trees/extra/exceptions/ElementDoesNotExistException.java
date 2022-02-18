package trees.extra.exceptions;

public class ElementDoesNotExistException extends RuntimeException {
    public ElementDoesNotExistException() {
        super("The searched element was not found in this tree");
    }
}
