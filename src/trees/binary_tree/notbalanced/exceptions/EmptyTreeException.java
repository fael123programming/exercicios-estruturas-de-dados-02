package trees.binary_tree.notbalanced.exceptions;

public class EmptyTreeException extends RuntimeException {
    public EmptyTreeException() {
        super("This tree is empty");
    }
}
