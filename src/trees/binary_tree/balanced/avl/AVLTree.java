package trees.binary_tree.balanced.avl;

import trees.binary_tree.abstractstructure.AbstractBinaryTree;
import trees.binary_tree.abstractstructure.AbstractNode;

public class AVLTree<T extends Comparable<T>> extends AbstractBinaryTree<T> {
    public AVLTree(T rootData) {
        super(rootData);
    }

    public AVLTree() {}

    @Override
    protected AbstractNode<T> insertRecursive(AbstractNode<T> node, T data) {
        if (node == null)
            return this.castDataToNodeImplementation(data);
        if (data.compareTo(node.getData()) < 0)
            node.setLeftChild(this.insertRecursive(node.getLeftChild(), data));
        else /*if (data.compareTo(node.getData()) > 0)*/
            node.setRightChild(this.insertRecursive(node.getRightChild(), data));
//        else
//            return node;
        this.updateHeight((AVLNode<T>) node);
        return this.applyRotation((AVLNode<T>) node);
    }

    @Override
    protected AbstractNode<T> castDataToNodeImplementation(T data) {
        return data != null ? new AVLNode<T>(data) : null;
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
        this.updateHeight((AVLNode<T>) node);
        return this.applyRotation((AVLNode<T>) node);
    }

    private void updateHeight(AVLNode<T> node) {
        node.setHeight(Math.max(node.getLeftChildHeight(), node.getRightChildHeight()) + 1);
    }

    private AbstractNode<T> applyRotation(AVLNode<T> node) {
        int balancingFactor = node.getBalancingFactor();
        if (balancingFactor > 1) { //Apply a right rotation (the case is when we have a left-heavy situation).
            if (((AVLNode<T>) node.getLeftChild()).getBalancingFactor() < 0)
                node.setLeftChild(this.leftRotation(node.getLeftChild()));
            return this.rightRotation(node);
        }
        if (balancingFactor < -1) { //Apply a left rotation (the case is when we have a right-heavy situation).
            AVLNode<T> castedRightChild = (AVLNode<T>) node.getRightChild();
            if (((AVLNode<T>) node.getRightChild()).getBalancingFactor() > 0)
                node.setRightChild(this.rightRotation(node.getRightChild()));
            return this.leftRotation(node);
        }
        return node; //node is balanced, therefore, nothing should be done.
    }

    private AbstractNode<T> rightRotation(AbstractNode<T> node) {
        AbstractNode<T> nodeLeftChild = node.getLeftChild();
        AbstractNode<T> nodeLeftChildRightChild = nodeLeftChild.getRightChild();
        nodeLeftChild.setRightChild(node);
        node.setLeftChild(nodeLeftChildRightChild);
        this.updateHeight((AVLNode<T>) node);
        this.updateHeight((AVLNode<T>) nodeLeftChild);
        return nodeLeftChild; //This node took the place of node becoming the new root.
    }

    private AbstractNode<T> leftRotation(AbstractNode<T> node) {
        AbstractNode<T> nodeRightChild = node.getRightChild();
        AbstractNode<T> nodeRightChildLeftChild = nodeRightChild.getLeftChild();
        nodeRightChild.setLeftChild(node);
        node.setRightChild(nodeRightChildLeftChild);
        this.updateHeight((AVLNode<T>) node);
        this.updateHeight((AVLNode<T>) nodeRightChild);
        return nodeRightChild;
    }
}
