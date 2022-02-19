package trees.binary_tree.balanced.redblack;

import trees.binary_tree.abstractstructure.AbstractNode;

public class RedBlackNode<T extends Comparable<T>> extends AbstractNode<T> {
    private Color color;
    private RedBlackNode<T> parent;

    public RedBlackNode(T data, Color color) {
        super(data);
        this.color = color;
    }

    public RedBlackNode(T data) {
        this(data, Color.RED);
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
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
        this.color = this.color == Color.RED ? Color.BLACK : Color.RED;
    }

    @Override
    public String toString() {
        return super.getData() + " " + this.getColor();
    }
}
