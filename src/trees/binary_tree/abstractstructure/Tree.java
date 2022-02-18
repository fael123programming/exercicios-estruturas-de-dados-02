package trees.binary_tree.abstractstructure;

import trees.binary_tree.notbalanced.classes.Node;
import trees.binary_tree.notbalanced.exceptions.ElementDoesNotExistException;
import trees.binary_tree.notbalanced.exceptions.EmptyTreeException;

public interface Tree<T extends Comparable<T>> {
    int IN_ORDER = 0, PREFIX = -1, POSTFIX = 1;

    boolean isEmpty();

    int size();

    T getMax() throws EmptyTreeException;

    T getMin() throws EmptyTreeException;

    Node<T> search(T data) throws EmptyTreeException;

    void delete(T data) throws EmptyTreeException, ElementDoesNotExistException;

    void clean();

    void insert(T data) throws IllegalArgumentException;

    void insert(T[] data) throws IllegalArgumentException;

    void print() throws EmptyTreeException;

    void print(int mode) throws EmptyTreeException;
}
