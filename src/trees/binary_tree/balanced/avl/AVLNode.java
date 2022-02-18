package trees.binary_tree.balanced.avl;

import trees.binary_tree.abstractstructure.AbstractNode;

public class AVLNode<T extends Comparable<T>> extends AbstractNode<T> {
    private int height;

    {
        height = 1;
    }

    public AVLNode(T data) {
        super(data);
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBalancingFactor() {
        return this.getLeftChildHeight() - this.getRightChildHeight();
    }

    public int getLeftChildHeight() {
        if (!this.hasLeftChild())
            return 0;
        return ((AVLNode<T>) this.getLeftChild()).height;
    }

    public int getRightChildHeight() {
        if (!this.hasRightChild())
            return 0;
        return ((AVLNode<T>) this.getRightChild()).height;
    }
}
