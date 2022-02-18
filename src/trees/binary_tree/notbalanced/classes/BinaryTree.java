package trees.binary_tree.notbalanced.classes;

import trees.binary_tree.abstractstructure.Tree;
import trees.binary_tree.notbalanced.exceptions.*;

public class BinaryTree<T extends Comparable<T>> implements Tree<T> {
    private Node<T> root;

    public BinaryTree() {}

    public BinaryTree(T value) {
        this.root = new Node<>(value);
    }

    public Node<T> getRoot() {
        return this.root;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public int size() {
        Counter counter = new Counter();
        count(counter, this.root);
        return counter.getNumber();
    }

    @Override
    public void print() throws EmptyTreeException {
        this.checkTreeIsEmpty();
        printInOrder(this.root);
    }

    @Override
    public void print(int mode) throws EmptyTreeException, IllegalArgumentException {
        this.checkTreeIsEmpty();
        switch(mode) {
            case BinaryTree.IN_ORDER -> printInOrder(this.root);
            case BinaryTree.POSTFIX -> printPostfix(this.root);
            case BinaryTree.PREFIX -> printPrefix(this.root);
            default -> throw new IllegalArgumentException("unknown mode " + mode + " for printing");
        }
    }

    @Override
    public Node<T> search(T value) throws EmptyTreeException, IllegalArgumentException {
        this.checkTreeIsEmpty();
        this.checkNull(value);
        return searchRecursive(this.root, value);
    }

    @Override
    public void insert(T[] elements) throws IllegalArgumentException {
        this.checkNull(elements);
        for (T t : elements) {
            this.checkNull(t);
            this.insert(t);
        }
    }

    @Override
    public void insert(T data) {
        this.checkNull(data);
        Node<T> toInsert = new Node<>(data);
        if (this.isEmpty())
            this.root = toInsert;
        else
            insertRecursive(this.root, toInsert);
    }

    @Override
    public void clean() {
        if (this.root != null)
            this.root = null;
    }

    @Override
    public void delete(T element) {
         if (this.search(element) == null)
             throw new ElementDoesNotExistException();
        deleteRecursive(this.root, element);
    }

    @Override
    public T getMax() throws EmptyTreeException{
        this.checkTreeIsEmpty();
        return this.getMax(this.root);
    }

    @Override
    public T getMin() throws EmptyTreeException {
        this.checkTreeIsEmpty();
        return this.getMin(this.root);
    }

    private void count(Counter counter, Node<T> root) {
        if (root == null)
            return;
        counter.increment();
        count(counter, root.getRightChild());
        count(counter, root.getLeftChild());
    }

    private void checkTreeIsEmpty() throws EmptyTreeException {
        if (this.isEmpty())
            throw new EmptyTreeException();
    }

    private void checkNull(Object obj) throws IllegalArgumentException {
        if (obj == null)
            throw new IllegalArgumentException("null argument passed");
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

    private Node<T> insertRecursive(Node<T> node, Node<T> toInsert) {
        if (node == null)
            node = toInsert;
        else if (toInsert.getData().compareTo(node.getData()) < 0)
            node.setLeftChild(insertRecursive(node.getLeftChild(), toInsert));
        else
            node.setRightChild(insertRecursive(node.getRightChild(), toInsert));
        return node;
    }

    private Node<T> deleteRecursive(Node<T> node, T element) {
        if (node == null)
            return null;
        else if (node.getData().compareTo(element) > 0)
            node.setLeftChild(this.deleteRecursive(node.getLeftChild(), element));
        else if (node.getData().compareTo(element) < 0)
            node.setRightChild(this.deleteRecursive(node.getRightChild(), element));
        else { //We have found the wanted element...
            if (node.getLeftChild() == null && node.getRightChild() == null) //It has no children...
                node = null;
             else if (node.getLeftChild() == null) //It has only one child...
                node = node.getRightChild();
             else if (node.getRightChild() == null) //It has only one child...
                 node = node.getLeftChild();
             else { //It has two children...
                 //Find the successor of the element to be deleted.
                 node.setData(this.getMin(node.getRightChild()));
                 node.setRightChild(this.deleteRecursive(node.getRightChild(), node.getData()));
            }
        }
        return node;
    }

    private T getMin(Node<T> node) {
        this.checkNull(node);
        while(node.hasLeftChild())
            node = node.getLeftChild();
        return node.getData();
    }

    private T getMax(Node<T> node) {
        this.checkNull(node);
        while (node.hasRightChild())
            node = node.getRightChild();
        return node.getData();
    }
}
