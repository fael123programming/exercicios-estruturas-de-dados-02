package trees.binary_tree.balanced.avl.classes;


public class AVLTree {
    private AVLNode root;

    public AVLTree(int rootValue) {
        this.root = new AVLNode(rootValue);
    }

    public AVLTree() {}

    public AVLNode getRoot() {
        return this.root;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void insert(int element) {
        if (this.isEmpty())
            this.root = new AVLNode(element);
        else
            insertRecursive();
    }

    private AVLNode insertRecursive(AVLNode node, AVLNode toInsert) {

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
