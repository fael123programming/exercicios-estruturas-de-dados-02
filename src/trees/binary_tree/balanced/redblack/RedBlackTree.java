package trees.binary_tree.balanced.redblack;

import trees.binary_tree.abstractstructure.AbstractBinaryTree;
import trees.binary_tree.abstractstructure.AbstractNode;
import trees.extra.exceptions.ElementDoesNotExistException;

public class RedBlackTree<T extends Comparable<T>> extends AbstractBinaryTree<T> {
    public RedBlackTree(T data) {
        this.insert(data);
    }

    public RedBlackTree() {}

    /**
     * Inserts new data into the tree maintaining all red-black
     * properties and constraints.
     * @param data the new data to be inserted
     * @throws IllegalArgumentException if data is null
     */
    @Override
    public void insert(T data) throws IllegalArgumentException {
        super.checkNull(data);
        RedBlackNode<T> toInsert = new RedBlackNode<>(data);
        this.root = this.insertRecursive(this.root, toInsert);
        super.nodes++;
        this.recolorAndRotate(toInsert);
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

    /**
     * Upwards from the given node towards `this.root`.
     * @param node the node where to start recoloring and/or rotating
     */
    private void recolorAndRotate(RedBlackNode<T> node) {
        RedBlackNode<T> treeRoot = (RedBlackNode<T>) this.root;
        if (treeRoot.getColorNumber() == RedBlackNode.RED)
            treeRoot.setColorNumber(RedBlackNode.BLACK);
        RedBlackNode<T> nodeParent = node.getParent();
        if (node == this.root || nodeParent.getColorNumber() == RedBlackNode.BLACK)
            return; //There is nothing to do in this case: until here we encompass the 1st and 2nd case on insertions.
        RedBlackNode<T> nodeGrandParent = nodeParent.getParent();
        RedBlackNode<T> nodeUncle = (RedBlackNode<T>) (nodeParent.isLeftChild() ? nodeGrandParent.getRightChild() : nodeGrandParent.getLeftChild());
        if (nodeUncle != null && nodeUncle.getColorNumber() == RedBlackNode.RED) //Recoloring going upward the tree: it encompasses the 3rd case.
            this.doRecoloring(nodeParent, nodeUncle, nodeGrandParent);
        else if (nodeParent.isLeftChild()) //If nodeUncle is null, it is considered to be black. Then we reach the 4th case.
            this.handleLeftSituations(node, nodeParent, nodeGrandParent);
        else
            this.handleRightSituations(node, nodeParent, nodeGrandParent);
    }

    private void doRecoloring(RedBlackNode<T> nodeParent, RedBlackNode<T> nodeUncle, RedBlackNode<T> nodeGrandParent) {
        nodeParent.flipColor();
        nodeUncle.flipColor();
        nodeGrandParent.flipColor();
        this.recolorAndRotate(nodeGrandParent);
//        After making the recoloring steps, call the method liable for checking when to change color or rotate
//        but now over the grandparent of the node just inserted.
    }

    private void handleLeftSituations(RedBlackNode<T> node, RedBlackNode<T> nodeParent, RedBlackNode<T> nodeGrandParent) {
        if (!node.isLeftChild()) { //If node is a right child, we`ll do a double right rotation.
            this.leftRotation(nodeParent);
            node.flipColor();
        } else
            nodeParent.flipColor();
        nodeGrandParent.flipColor();
        this.rightRotation(nodeGrandParent);
        this.recolorAndRotate(node.isLeftChild() ? nodeParent : nodeGrandParent);
    }

    private void handleRightSituations(RedBlackNode<T> node, RedBlackNode<T> nodeParent, RedBlackNode<T> nodeGrandParent) {
//      This method still has problems on recoloring!
        if (node.isLeftChild()) {
            this.rightRotation(nodeParent);
            nodeParent.flipColor();
            nodeGrandParent.flipColor();
        } else
            nodeParent.flipColor();
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
    public AbstractNode<T> castDataToNodeImplementation(T data) {
        return new RedBlackNode<>(data);
    }

    @Override
    public void delete(T data) throws ElementDoesNotExistException {
        RedBlackNode<T> toDelete = (RedBlackNode<T>) this.search(data);
        if (toDelete == null)
            throw new ElementDoesNotExistException();
        this.root = this.deleteRecursive(this.root, data);
        this.nodes--;
        if (toDelete.getColorNumber() == RedBlackNode.RED)
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
