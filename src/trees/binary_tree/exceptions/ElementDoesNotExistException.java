package trees.binary_tree.exceptions;

public class ElementDoesNotExistException extends RuntimeException {
    public ElementDoesNotExistException(int element) {
        super(element + " was not found in this tree");
    }
}
