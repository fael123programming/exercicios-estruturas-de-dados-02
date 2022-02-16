package trees.abstracttree;

import trees.binary_tree.notbalanced.classes.Node;
import trees.binary_tree.notbalanced.exceptions.EmptyTreeException;

public interface Tree<T extends Comparable<T>> {
    /**
     * IN_ORDER, POSTFIX and PREFIX attributes refer to the modes
     * of traversing a tree that must be implemented in the method
     * print(int mode) in all classes that implement this interface.
     */
    int IN_ORDER = 0 , POSTFIX = 1, PREFIX = -1;

    void insert(T newElement);

    void insert(T[] elements);

    void delete(T element) throws EmptyTreeException;

    Node<T> search(T element) throws EmptyTreeException;

    /**
     * Traverses a tree in a standard mode, commonly
     * IN_ORDER in which all elements are sorted.
     * @throws EmptyTreeException if this tree is empty
     */
    void print() throws EmptyTreeException;

    void print(int mode) throws EmptyTreeException;

    boolean isEmpty();

    int size();
}
