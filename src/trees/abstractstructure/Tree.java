package trees.abstractstructure;

import trees.extra.node.Node;
import trees.extra.exceptions.ElementDoesNotExistException;
import trees.extra.exceptions.EmptyTreeException;

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
