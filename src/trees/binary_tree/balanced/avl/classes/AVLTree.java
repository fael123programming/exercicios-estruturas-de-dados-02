package trees.binary_tree.balanced.avl.classes;

import trees.binary_tree.notbalanced.classes.BinaryTree;
import trees.binary_tree.notbalanced.classes.Node;

public class AVLTree<T extends Comparable<T>> extends BinaryTree<T> {
    private AVLNode<T> root;

    public AVLTree(T rootValue) {
        this.root = new AVLNode<>(rootValue);
    }

    public AVLTree() {}

    public AVLNode<T> getRoot() {
        return this.root;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public Node<T> insertRecursive(Node<T> node, Node<T> toInsert) {
        if (node == null)
            node = toInsert;
        else if (toInsert.getInfo().compareTo(node.getInfo()) < 0)
            node.setLeftChild(insertRecursive(node.getLeftChild(), toInsert));
        else
            node.setRightChild(insertRecursive(node.getRightChild(), toInsert));
        return node;
        this.updateHeight(node);
    }

    private void updateHeight(Node<T> node) {

    }

    private void LLRotation(AVLNode node) {
        AVLNode auxiliaryNode = node.getLeftChild();
        node.setLeftChild(auxiliaryNode.getRightChild());
        auxiliaryNode.setRightChild(node);
        node.setHeight(Math.max(node.getLeftChild().getHeight(), node.getRightChild().getHeight()) + 1);
        auxiliaryNode.setHeight(Math.max(auxiliaryNode.getLeftChild().getHeight(), node.getHeight()) + 1);
    }

    private void RRRotation(AVLNode node) {
        AVLNode auxiliaryNode = node.getRightChild();
        node.setRightChild(auxiliaryNode.getLeftChild());
        auxiliaryNode.setLeftChild(node);
        node.setHeight(Math.max(node.getLeftChild().getHeight(), node.getRightChild().getHeight()) + 1);
        auxiliaryNode.setHeight(Math.max(auxiliaryNode.getRightChild().getHeight(), node.getHeight()) + 1);
    }

    private void LRRotation(AVLNode node) {
        this.RRRotation(node.getLeftChild());
        this.LLRotation(node);
    }

    private void RLRotation(AVLNode node) {
        this.LLRotation(node.getRightChild());
        this.RRRotation(node);
    }
}
