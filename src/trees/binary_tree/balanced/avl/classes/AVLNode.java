package trees.binary_tree.balanced.avl.classes;

import trees.binary_tree.notbalanced.classes.Node;

public class AVLNode<T extends Comparable<T>>  extends Node<T> {
    private int height;

    public AVLNode(T info) {
        super(info);
    }

    public T getInfo() {
        return this.info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Node<T> getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(AVLNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(AVLNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public int getBalancingFactor() {
        int leftChildHeight = 0, rightChildHeight = 0;
        if (this.hasLeftChild())
            leftChildHeight = ((AVLNode<T>) this.getLeftChild()).getHeight();
        if (this.hasRightChild())
            rightChildHeight = ((AVLNode<T>) this.getRightChild()).getHeight();
        return Math.abs(leftChildHeight - rightChildHeight);
    }

    public boolean hasLeftChild() {
        return this.getLeftChild() != null;
    }

    public boolean hasRightChild() {
        return this.getRightChild() != null;
    }
}
