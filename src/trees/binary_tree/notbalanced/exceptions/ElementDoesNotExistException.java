package trees.binary_tree.notbalanced.exceptions;

public class ElementDoesNotExistException extends RuntimeException {
    public ElementDoesNotExistException() {
        super("The searched element was not found in this tree");
    }
}
