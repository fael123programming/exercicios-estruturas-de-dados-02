package trees.binary_tree.notbalanced.classes;

public class Node<T extends Comparable<T>> {
    protected T info;
    protected Node<T> rightChild, leftChild;

    public Node(T info) {
        this.info = info;
    }

    public T getInfo() {
        return this.info;
    }

    public void setInfo(T info) {
        this.info = info;
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
}

