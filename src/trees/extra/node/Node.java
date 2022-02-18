package trees.extra.node;

public class Node<T extends Comparable<T>> {
    private T data;
    private int height;
    private Node<T> rightChild, leftChild;

    {
        height = 1;
    }

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public Node<T> getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
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

    public boolean hasLeftChild() {
        return this.getLeftChild() != null;
    }

    public boolean hasRightChild() {
        return this.getRightChild() != null;
    }

    public int getLeftChildHeight() {
        if (!this.hasLeftChild())
            return 0;
        return this.leftChild.height;
    }

    public int getRightChildHeight() {
        if (!this.hasRightChild())
            return 0;
        return this.rightChild.height;
    }
}

