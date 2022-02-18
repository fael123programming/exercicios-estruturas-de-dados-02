package trees.binary_tree.classes;

import trees.binary_tree.abstractstructure.AbstractNode;

public class Node<T extends Comparable<T>> extends AbstractNode<T> {
    public Node(T data) {
        super(data);
    }
}

