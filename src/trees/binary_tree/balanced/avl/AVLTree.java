package trees.binary_tree.balanced.avl;

import trees.extra.counter.Counter;
import trees.extra.exceptions.ElementDoesNotExistException;
import trees.extra.exceptions.EmptyTreeException;

public class AVLTree<T extends Comparable<T>> {
    private AVLNode<T> root;
    public static final int IN_ORDER = 0, PREFIX = -1, POSTFIX = 1;

    public AVLTree(T rootValue) {
        this.root = new AVLNode<>(rootValue);
    }

    public AVLTree() {}

    public AVLNode<T> getRoot() {
        return this.root;
    }

    public int nodes() {
        if (this.isEmpty())
            return 0;
        Counter counter = new Counter();
        count(counter, this.root);
        return counter.getNumber();
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void insert(T data) throws IllegalArgumentException {
        this.checkNull(data);
        this.root = insertRecursive(this.root, data);
    }

    public void insert(T[] data) throws IllegalArgumentException {
        this.checkNull(data);
        for (T dt : data) {
            this.checkNull(dt);
            this.insert(dt);
        }
    }

    public void delete(T data) throws EmptyTreeException, IllegalArgumentException, ElementDoesNotExistException {
        this.checkTreeIsEmpty();
        this.checkNull(data);
        if (this.search(data) == null)
            throw new ElementDoesNotExistException();
        this.root = this.deleteRecursive(this.root, data);
    }

    public T getMax() throws EmptyTreeException {
        this.checkTreeIsEmpty();
        return this.getMax(this.root);
    }

    public T getMin() throws EmptyTreeException {
        this.checkTreeIsEmpty();
        return this.getMin(this.root);
    }

    public void print() throws EmptyTreeException {
        this.checkTreeIsEmpty();
        printInOrder(this.root);
    }

    public void print(int mode) throws EmptyTreeException {
        this.checkTreeIsEmpty();
        switch(mode) {
            case AVLTree.IN_ORDER -> printInOrder(this.root);
            case AVLTree.POSTFIX -> printPostfix(this.root);
            case AVLTree.PREFIX -> printPrefix(this.root);
            default -> throw new IllegalArgumentException("unknown mode " + mode + " for printing");
        }
    }

    public AVLNode<T> search(T data) throws EmptyTreeException, IllegalArgumentException {
        this.checkTreeIsEmpty();
        this.checkNull(data);
        return this.searchRecursive(this.root, data);
    }

    public void clean() {
        if (this.root != null)
            this.root = null;
    }

    private void count(Counter counter, AVLNode<T> root) {
        if (root == null)
            return;
        counter.increment();
        count(counter, root.getRightChild());
        count(counter, root.getLeftChild());
    }

    private AVLNode<T> insertRecursive(AVLNode<T> node, T data) {
        if (node == null)
            return new AVLNode<>(data);
        if (data.compareTo(node.getData()) < 0)
            node.setLeftChild(this.insertRecursive(node.getLeftChild(), data));
        else if (data.compareTo(node.getData()) > 0)
            node.setRightChild(this.insertRecursive(node.getRightChild(), data));
        else
            return node;
        this.updateHeight(node);
        return this.applyRotation(node);
    }

    private AVLNode<T> deleteRecursive(AVLNode<T> node, T data) {
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
        this.updateHeight(node);
        return this.applyRotation(node);
    }

    private AVLNode<T> searchRecursive(AVLNode<T> node, T value) {
        if (node == null)
            return null;
        if (node.getData() == value)
            return node;
        else if (node.getData().compareTo(value) > 0)
            return searchRecursive(node.getLeftChild(), value);
        else
            return searchRecursive(node.getRightChild(), value);
    }

    private void updateHeight(AVLNode<T> node) {
        node.setHeight(Math.max(node.getLeftChildHeight(), node.getRightChildHeight()) + 1);
    }

    private AVLNode<T> applyRotation(AVLNode<T> node) {
        int balancingFactor = node.getBalancingFactor();
        if (balancingFactor > 1) { //Apply a right rotation (the case is when we have a left-heavy situation).
            if (node.getLeftChild().getBalancingFactor() < 0)
                node.setLeftChild(this.leftRotation(node.getLeftChild()));
            return this.rightRotation(node);
        }
        if (balancingFactor < -1) { //Apply a left rotation (the case is when we have a right-heavy situation).
            if (node.getRightChild().getBalancingFactor() > 0)
                node.setRightChild(this.rightRotation(node.getRightChild()));
            return this.leftRotation(node);
        }
        return node; //node is balanced, therefore, nothing should be done.
    }

    private AVLNode<T> rightRotation(AVLNode<T> node) {
        AVLNode<T> nodeLeftChild = node.getLeftChild();
        AVLNode<T> nodeLeftChildRightChild = nodeLeftChild.getRightChild();
        nodeLeftChild.setRightChild(node);
        node.setLeftChild(nodeLeftChildRightChild);
        this.updateHeight(node);
        this.updateHeight(nodeLeftChild);
        return nodeLeftChild; //This node took the place of node becoming the new root.
    }

    private AVLNode<T> leftRotation(AVLNode<T> node) {
        AVLNode<T> nodeRightChild = node.getRightChild();
        AVLNode<T> nodeRightChildLeftChild = nodeRightChild.getLeftChild();
        nodeRightChild.setLeftChild(node);
        node.setRightChild(nodeRightChildLeftChild);
        this.updateHeight(node);
        this.updateHeight(nodeRightChild);
        return nodeRightChild;
    }

    private void checkNull(Object object) {
        if (object == null)
            throw new IllegalArgumentException("null argument passed");
    }

    private void checkTreeIsEmpty() throws EmptyTreeException {
        if (this.isEmpty())
            throw new EmptyTreeException();
    }

    private T getMax(AVLNode<T> node) {
        this.checkNull(node);
        while (node.hasRightChild())
            node = node.getRightChild();
        return node.getData();
    }

    private T getMin(AVLNode<T> node) {
        this.checkNull(node);
        while (node.hasLeftChild())
            node = node.getLeftChild();
        return node.getData();
    }

    private void printInOrder(AVLNode<T> aNode) {
        if (aNode == null)
            return;
        printInOrder(aNode.getLeftChild());
        System.out.println(aNode.getData());
        printInOrder(aNode.getRightChild());
    }

    private void printPostfix(AVLNode<T> aNode) {
        if (aNode == null)
            return;
        printPostfix(aNode.getRightChild());
        printPostfix(aNode.getLeftChild());
        System.out.println(aNode.getData());
    }

    private void printPrefix(AVLNode<T> aNode) {
        if (aNode == null)
            return;
        System.out.println(aNode.getData());
        printPrefix(aNode.getLeftChild());
        printPrefix(aNode.getRightChild());
    }
}
