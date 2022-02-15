package trees.binary_tree.balanced.avl.classes;

public class AVLNode {
    private int info, height;
    private AVLNode leftChild, rightChild;

    public AVLNode(int info) {
        this.info = info;
    }

    public int getInfo() {
        return this.info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public AVLNode getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(AVLNode leftChild) {
        this.leftChild = leftChild;
    }

    public AVLNode getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(AVLNode rightChild) {
        this.rightChild = rightChild;
    }

    public int getBalancingFactor() {
        int leftChildHeight = 0, rightChildHeight = 0;
        if (this.hasLeftChild())
            leftChildHeight = this.leftChild.height;
        if (this.hasRightChild())
            rightChildHeight = this.rightChild.height;
        return Math.abs(leftChildHeight - rightChildHeight);
    }

    public boolean hasLeftChild() {
        return this.getLeftChild() != null;
    }

    public boolean hasRightChild() {
        return this.getRightChild() != null;
    }
}
