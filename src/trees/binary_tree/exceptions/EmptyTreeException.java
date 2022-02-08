package trees.binary_tree.exceptions;

public class EmptyTreeException extends RuntimeException {
    public EmptyTreeException() {
        super("This tree is empty");
    }
}
