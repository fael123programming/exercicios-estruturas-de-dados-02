package trees.binary_tree.classes;

public class Node {
    private int info;
    private Node rightChild, leftChild;

    public Node(int info, Node leftChild, Node rightChild) {
        this.info = info;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Node(int info) {
        this.info = info;
    }

    public int getInfo() {
        return this.info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public Node getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Node getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public boolean hasLeftChild() {
        return this.leftChild != null;
    }

    public boolean hasRightChild() {
        return this.rightChild != null;
    }
}
