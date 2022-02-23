package trees.binary_tree.balanced.redblack;

import trees.binary_tree.abstractstructure.AbstractNode;

public class RedBlackNode<T extends Comparable<T>> extends AbstractNode<T> {
    public static final int RED = 0, BLACK = 1;
    private int colorNumber; //0: red; 1: black (to reduce memory storage used)
    private RedBlackNode<T> parent;
    private boolean doubleBlack;

    public RedBlackNode(T data, int colorNumber) {
        super(data);
        this.assertColorNumberIsValid(colorNumber);
        this.colorNumber = colorNumber;
    }

    public RedBlackNode(T data) {
        this(data, RedBlackNode.RED);
    }

    public RedBlackNode<T> getUncle() {
        if (this.parent == null)
            return null;
        RedBlackNode<T> grandpa = this.parent.parent;
        if (grandpa == null)
            return null;
        return (RedBlackNode<T>) (this.parent.isLeftChild() ? grandpa.getRightChild() : grandpa.getLeftChild());
    }

    public RedBlackNode<T> getSibling() {
        if (this.parent == null)
            return null;
        return (RedBlackNode<T>) (this.isLeftChild() ? this.parent.getRightChild() : this.parent.getLeftChild());
    }

    public boolean hasRedChild() {
        return this.hasLeftChild() && ((RedBlackNode<T>) this.getLeftChild()).isRed() || this.hasRightChild() && ((RedBlackNode<T>) this.getRightChild()).isRed();
    }

    public boolean isBlack() {
        return this.colorNumber == RedBlackNode.BLACK;
    }

    public boolean isRed() {
        return this.colorNumber == RedBlackNode.RED;
    }

    public boolean isChildless() {
        return !this.hasLeftChild() && !this.hasRightChild();
    }

    public boolean areChildrenBlack() {
        return ((RedBlackNode<T>) this.getLeftChild()).isBlack() && ((RedBlackNode<T>) this.getRightChild()).isBlack();
    }

    public boolean isDoubleBlack() {
        return this.doubleBlack;
    }

    public void setDoubleBlack(boolean logicValue) {
        this.doubleBlack = logicValue;
    }

    public void swapColor(RedBlackNode<T> anotherNode) {
        if (anotherNode == null)
            throw new IllegalArgumentException("another node cannot be null");
        if (this.getColorNumber() == anotherNode.getColorNumber())
            return; //They are of same color.
        int tempColorNumber = anotherNode.getColorNumber();
        anotherNode.setColorNumber(this.getColorNumber());
        this.setColorNumber(tempColorNumber);
    }

    public void swapData(RedBlackNode<T> anotherNode) {
        if (anotherNode == null)
            throw new IllegalArgumentException("another node cannot be null");
        if (this.getData().compareTo(anotherNode.getData()) == 0)
            return; //They have same data.
        T temp = anotherNode.getData();
        anotherNode.setData(this.getData());
        this.setData(temp);
    }

    public String getColor() {
        return this.colorNumber == 1 ? "BLACK" : "RED";
    }

    public int getColorNumber() {
        return this.colorNumber;
    }

    public void setColorNumber(int colorNumber) {
        this.assertColorNumberIsValid(colorNumber);
        this.colorNumber = colorNumber;
    }

    public RedBlackNode<T> getParent() {
        return this.parent;
    }

    public void setParent(RedBlackNode<T> parent) {
        this.parent = parent;
    }

    public boolean isLeftChild() {
        return this.parent != null && this == this.parent.getLeftChild(); //Comparing memory references.
    }

    public void flipColor() {
        this.colorNumber = this.colorNumber == RedBlackNode.RED ? RedBlackNode.BLACK : RedBlackNode.RED;
    }

    public void blackfy() {
        if (this.colorNumber != RedBlackNode.BLACK)
            this.colorNumber = RedBlackNode.BLACK;
    }

    public void redfy() {
        if (this.colorNumber != RedBlackNode.RED)
            this.colorNumber = RedBlackNode.RED;
    }

    @Override
    public String toString() {
        return super.getData() + " " + this.getColor();
    }

    private void assertColorNumberIsValid(int colorNumber) {
        if (colorNumber < 0 || colorNumber > 1)
            throw new IllegalArgumentException("color number " + colorNumber + " is invalid: choose 1 for BLACK and 0 for RED");
    }
}
