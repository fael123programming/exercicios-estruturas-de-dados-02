package trees.binary_tree.balanced.avl.classes;

import trees.binary_tree.abstractstructure.Tree;
import trees.binary_tree.notbalanced.classes.Counter;
import trees.binary_tree.notbalanced.classes.Node;
import trees.binary_tree.notbalanced.exceptions.ElementDoesNotExistException;
import trees.binary_tree.notbalanced.exceptions.EmptyTreeException;

public class AVLTree<T extends Comparable<T>> implements Tree<T> {
    private Node<T> root;

    public AVLTree(T rootValue) {
        this.root = new Node<>(rootValue);
    }

    public AVLTree() {}

    public Node<T> getRoot() {
        return this.root;
    }

    @Override
    public int size() {
        if (this.isEmpty())
            return 0;
        Counter counter = new Counter();
        count(counter, this.root);
        return counter.getNumber();
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public void insert(T data) throws IllegalArgumentException {
        this.checkNull(data);
        this.root = insertRecursive(this.root, data);
    }

    @Override
    public void insert(T[] data) throws IllegalArgumentException {
        this.checkNull(data);
        for (T dt : data) {
            this.checkNull(dt);
            this.insert(dt);
        }
    }

    @Override
    public void delete(T data) throws EmptyTreeException, IllegalArgumentException, ElementDoesNotExistException {
        this.checkTreeIsEmpty();
        this.checkNull(data);
        if (this.search(data) == null)
            throw new ElementDoesNotExistException();
        this.root = this.deleteRecursive(this.root, data);
    }

    @Override
    public T getMax() throws EmptyTreeException {
        this.checkTreeIsEmpty();
        return this.getMax(this.root);
    }

    @Override
    public T getMin() throws EmptyTreeException {
        this.checkTreeIsEmpty();
        return this.getMin(this.root);
    }

    @Override
    public void print() throws EmptyTreeException {
        this.checkTreeIsEmpty();
        printInOrder(this.root);
    }

    @Override
    public void print(int mode) throws EmptyTreeException {
        this.checkTreeIsEmpty();
        switch(mode) {
            case Tree.IN_ORDER -> printInOrder(this.root);
            case Tree.POSTFIX -> printPostfix(this.root);
            case Tree.PREFIX -> printPrefix(this.root);
            default -> throw new IllegalArgumentException("unknown mode " + mode + " for printing");
        }
    }

    @Override
    public Node<T> search(T data) throws EmptyTreeException, IllegalArgumentException {
        this.checkTreeIsEmpty();
        this.checkNull(data);
        return this.searchRecursive(this.root, data);
    }

    @Override
    public void clean() {
        if (this.root != null)
            this.root = null;
    }

    private void count(Counter counter, Node<T> root) {
        if (root == null)
            return;
        counter.increment();
        count(counter, root.getRightChild());
        count(counter, root.getLeftChild());
    }

    private Node<T> insertRecursive(Node<T> node, T data) {
        if (node == null)
            return new Node<>(data);
        if (data.compareTo(node.getData()) < 0)
            node.setLeftChild(this.insertRecursive(node.getLeftChild(), data));
        else if (data.compareTo(node.getData()) > 0)
            node.setRightChild(this.insertRecursive(node.getRightChild(), data));
        else
            return node;
        this.updateHeight(node);
        return this.applyRotation(node);
    }

    private Node<T> deleteRecursive(Node<T> node, T data) {
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

    private Node<T> searchRecursive(Node<T> node, T value) {
        if (node == null)
            return null;
        if (node.getData() == value)
            return node;
        else if (node.getData().compareTo(value) > 0)
            return searchRecursive(node.getLeftChild(), value);
        else
            return searchRecursive(node.getRightChild(), value);
    }

    private void updateHeight(Node<T> node) {
        node.setHeight(Math.max(node.getLeftChildHeight(), node.getRightChildHeight()) + 1);
    }

    private Node<T> applyRotation(Node<T> node) {
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

    private Node<T> rightRotation(Node<T> node) {
        Node<T> nodeLeftChild = node.getLeftChild();
        Node<T> nodeLeftChildRightChild = nodeLeftChild.getRightChild();
        nodeLeftChild.setRightChild(node);
        node.setLeftChild(nodeLeftChildRightChild);
        this.updateHeight(node);
        this.updateHeight(nodeLeftChild);
        return nodeLeftChild; //This node took the place of node becoming the new root.
    }

    private Node<T> leftRotation(Node<T> node) {
        Node<T> nodeRightChild = node.getRightChild();
        Node<T> nodeRightChildLeftChild = nodeRightChild.getLeftChild();
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

    private T getMax(Node<T> node) {
        this.checkNull(node);
        while (node.hasRightChild())
            node = node.getRightChild();
        return node.getData();
    }

    private T getMin(Node<T> node) {
        this.checkNull(node);
        while (node.hasLeftChild())
            node = node.getLeftChild();
        return node.getData();
    }

    private void printInOrder(Node<T> aNode) {
        if (aNode == null)
            return;
        printInOrder(aNode.getLeftChild());
        System.out.println(aNode.getData());
        printInOrder(aNode.getRightChild());
    }

    private void printPostfix(Node<T> aNode) {
        if (aNode == null)
            return;
        printPostfix(aNode.getRightChild());
        printPostfix(aNode.getLeftChild());
        System.out.println(aNode.getData());
    }

    private void printPrefix(Node<T> aNode) {
        if (aNode == null)
            return;
        System.out.println(aNode.getData());
        printPrefix(aNode.getLeftChild());
        printPrefix(aNode.getRightChild());
    }
}
