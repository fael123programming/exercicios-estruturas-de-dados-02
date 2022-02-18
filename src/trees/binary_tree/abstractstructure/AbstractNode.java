package trees.binary_tree.abstractstructure;

import java.util.Objects;

public abstract class AbstractNode<T extends Comparable<T>> {
    private T data;
    private AbstractNode<T> leftChild, rightChild;

    public AbstractNode(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public AbstractNode<T> getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(AbstractNode<T> node) {
        this.leftChild = node;
    }

    public AbstractNode<T> getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(AbstractNode<T> node) {
        this.rightChild = node;
    }

    public boolean hasLeftChild() {
        return this.leftChild != null;
    }

    public boolean hasRightChild() {
        return this.rightChild != null;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }

    @Override
    public boolean equals(Object another) {
        if (!(another instanceof AbstractNode casted))
            return false;
        if (casted.data == null)
            return false;
        return casted.data.compareTo(this.data) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.data);
    }
}
