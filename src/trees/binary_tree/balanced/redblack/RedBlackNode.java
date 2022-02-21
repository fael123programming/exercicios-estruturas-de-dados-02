package trees.binary_tree.balanced.redblack;

import trees.binary_tree.abstractstructure.AbstractNode;

public class RedBlackNode<T extends Comparable<T>> extends AbstractNode<T> {
    private int colorNumber; //0: red; 1: black (to reduce memory storage used)
    private RedBlackNode<T> parent;
    public static final int RED = 0, BLACK = 1;

    public RedBlackNode(T data, int colorNumber) {
        super(data);
        this.assertColorNumberIsValid(colorNumber);
        this.colorNumber = colorNumber;
    }

    public RedBlackNode(T data) {
        this(data, RedBlackNode.RED);
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

    @Override
    public String toString() {
        return super.getData() + " " + this.getColor();
    }

    private void assertColorNumberIsValid(int colorNumber) {
        if (colorNumber < 0 || colorNumber > 1)
            throw new IllegalArgumentException("color number " + colorNumber + " is invalid: choose 1 for BLACK and 0 for RED");
    }
}
