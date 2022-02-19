package trees.binary_tree.balanced.redblack;

import trees.binary_tree.abstractstructure.AbstractBinaryTree;
import trees.binary_tree.abstractstructure.AbstractNode;
import trees.extra.exceptions.ElementDoesNotExistException;

public class RedBlackTree<T extends Comparable<T>> extends AbstractBinaryTree<T> {
    public RedBlackTree(T data) {
        this.insert(data);
    }

    public RedBlackTree() {}

    @Override
    public void insert(T data) throws IllegalArgumentException {
        super.checkNull(data);
        RedBlackNode<T> toInsert = new RedBlackNode<>(data);
        this.root = this.insertRecursive(this.root, toInsert);
        this.recolorAndRotate(toInsert);
    }

    /**
     * Upwards from the given node towards `this.root`.
     * @param node the node where to start recoloring and/or rotating
     */
    private void recolorAndRotate(RedBlackNode<T> node) {
        ((RedBlackNode<T>) this.root).setColor(Color.BLACK); //It is now BLACK.
        RedBlackNode<T> nodeParent = node.getParent();
        if (node == this.root || nodeParent.getColor() == Color.BLACK)
            return; //There is nothing to do in this case!
        RedBlackNode<T> nodeGrandParent = nodeParent.getParent();
        RedBlackNode<T> nodeUncle = (RedBlackNode<T>) (nodeParent.isLeftChild() ? nodeGrandParent.getRightChild() : nodeGrandParent.getLeftChild());
        if (nodeUncle != null && nodeUncle.getColor() == Color.RED) //Recolor going upward the tree.
            this.doRecoloring(nodeParent, nodeUncle, nodeGrandParent);
        else if (nodeParent.isLeftChild())
            this.handleLeftSituations(node, nodeParent, nodeGrandParent);
        else
            this.handleRightSituations(node, nodeParent, nodeGrandParent);
    }

    private void doRecoloring(RedBlackNode<T> nodeParent, RedBlackNode<T> nodeUncle, RedBlackNode<T> nodeGrandParent) {
        nodeParent.flipColor();
        nodeUncle.flipColor();
        nodeGrandParent.flipColor();
        this.recolorAndRotate(nodeGrandParent);
    }

    private void handleLeftSituations(RedBlackNode<T> node, RedBlackNode<T> nodeParent, RedBlackNode<T> nodeGrandParent) {
        if (!node.isLeftChild())
            this.leftRotation(nodeParent);
        nodeParent.flipColor();
        nodeGrandParent.flipColor();
        this.rightRotation(nodeGrandParent);
        this.recolorAndRotate(node.isLeftChild() ? nodeParent : nodeGrandParent);
    }

    private void handleRightSituations(RedBlackNode<T> node, RedBlackNode<T> nodeParent, RedBlackNode<T> nodeGrandParent) {
        if (node.isLeftChild())
            this.rightRotation(nodeParent);
        nodeParent.flipColor();
        nodeGrandParent.flipColor();
        this.leftRotation(nodeGrandParent);
        this.recolorAndRotate(node.isLeftChild() ? nodeGrandParent : nodeParent);
    }

    private void leftRotation(RedBlackNode<T> node) {
        RedBlackNode<T> nodeRightChild = (RedBlackNode<T>) node.getRightChild();
        node.setRightChild(nodeRightChild.getLeftChild());
        if (node.getRightChild() != null)
            ((RedBlackNode<T>) node.getRightChild()).setParent(node);
        nodeRightChild.setLeftChild(node);
        nodeRightChild.setParent(node.getParent());
        this.updateChildrenOfParentNode(node, nodeRightChild);
        node.setParent(nodeRightChild);
    }

    private void rightRotation(RedBlackNode<T> node) {
        RedBlackNode<T> nodeLeftChild = (RedBlackNode<T>) node.getLeftChild();
        node.setLeftChild(nodeLeftChild.getRightChild());
        if (node.getLeftChild() != null)
            ((RedBlackNode<T>) node.getLeftChild()).setParent(node);
        nodeLeftChild.setRightChild(node);
        nodeLeftChild.setParent(node.getParent());
        this.updateChildrenOfParentNode(node, nodeLeftChild);
        node.setParent(nodeLeftChild);
    }

    private void updateChildrenOfParentNode(RedBlackNode<T> node, RedBlackNode<T> anotherNode) {
        if (node.getParent() == null)
            this.root = anotherNode;
        else if (node.isLeftChild())
            node.getParent().setLeftChild(anotherNode);
        else
            node.getParent().setRightChild(anotherNode);
    }

    @Override
    protected AbstractNode<T> insertRecursive(AbstractNode<T> node, AbstractNode<T> toInsert) {
        if (node == null)
            return toInsert;
        if (toInsert.getData().compareTo(node.getData()) < 0) {
            node.setLeftChild(this.insertRecursive(node.getLeftChild(), toInsert));
            ((RedBlackNode<T>) node.getLeftChild()).setParent((RedBlackNode<T>) node);
        } else {
            node.setRightChild(this.insertRecursive(node.getRightChild(), toInsert));
            ((RedBlackNode<T>) node.getRightChild()).setParent((RedBlackNode<T>) node);
        }
        return node;
    }

    @Override
    public AbstractNode<T> castDataToNodeImplementation(T data) {
        return new RedBlackNode<>(data);
    }

    @Override
    public void delete(T data) throws ElementDoesNotExistException {
        RedBlackNode<T> toDelete = (RedBlackNode<T>) this.search(data);
        if (toDelete == null)
            throw new ElementDoesNotExistException();
        this.root = this.deleteRecursive(this.root, data);
        if (toDelete.getColor() == Color.RED)
            return; //Deleting red nodes does not require any further change on the tree (recoloring or rotations).
        this.recolorAndRotate(); //Otherwise, it will be necessary to check if the red-black tree rules still hold.
    }

    @Override
    protected AbstractNode<T> deleteRecursive(AbstractNode<T> node, T data) {
        if (node == null)
            return null;
        if (node.getData().compareTo(data) > 0)
            node.setLeftChild(this.deleteRecursive(node.getLeftChild(), data));
        else if (node.getData().compareTo(data) < 0)
            node.setRightChild(this.deleteRecursive(node.getRightChild(), data));
        else {
            if (!node.hasLeftChild())
                return node.getRightChild();
            if (!node.hasRightChild())
                return node.getLeftChild();
            node.setData(this.getMax(node.getLeftChild()));
            node.setLeftChild(this.deleteRecursive(node.getLeftChild(), node.getData()));
        }
        return node;
    }

    /**
     * Downward from `this.root` towards leaves.
     */
    private void recolorAndRotate() {


    }
}
