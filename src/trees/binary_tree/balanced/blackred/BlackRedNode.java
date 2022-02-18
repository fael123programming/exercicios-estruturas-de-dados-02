package trees.binary_tree.balanced.blackred;

import trees.binary_tree.abstractstructure.AbstractNode;
import trees.binary_tree.balanced.avl.Color;

public class BlackRedNode<T extends Comparable<T>> extends AbstractNode<T> {
    private Color color;

    public BlackRedNode(T data, Color color) {
        super(data);
        this.color = color;
    }

    public BlackRedNode(T data) {
        this(data, Color.RED);
    }

    public String getColor() {
        return this.color.toString();
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
