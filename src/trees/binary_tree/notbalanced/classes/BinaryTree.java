package trees.binary_tree.notbalanced.classes;

import trees.abstracttree.Tree;
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

    private void count(Counter counter, Node<T> root) {
        if (root == null)
            return;
        counter.increment();
        count(counter, root.getRightChild());
        count(counter, root.getLeftChild());
    }

    @Override
    public void print() throws EmptyTreeException {
        checkWhetherTreeIsEmpty();
        printInOrder(this.root);
    }

    @Override
    public void print(int mode) throws EmptyTreeException {
        checkWhetherTreeIsEmpty();
        switch(mode) {
            case BinaryTree.IN_ORDER -> printInOrder(this.root);
            case BinaryTree.POSTFIX -> printPostfix(this.root);
            case BinaryTree.PREFIX -> printPrefix(this.root);
            default -> throw new IllegalArgumentException("unknown mode " + mode + " for printing");
        }
    }

    private void checkWhetherTreeIsEmpty() throws EmptyTreeException {
        if (isEmpty())
            throw new EmptyTreeException();
    }

    private void printInOrder(Node<T> aNode) {
        if (aNode == null)
            return;
        printInOrder(aNode.getLeftChild());
        System.out.println(aNode.getInfo());
        printInOrder(aNode.getRightChild());
    }

    private void printPostfix(Node<T> aNode) {
        if (aNode == null)
            return;
        printPostfix(aNode.getRightChild());
        printPostfix(aNode.getLeftChild());
        System.out.println(aNode.getInfo());
    }

    private void printPrefix(Node<T> aNode) {
        if (aNode == null)
            return;
        System.out.println(aNode.getInfo());
        printPrefix(aNode.getLeftChild());
        printPrefix(aNode.getRightChild());
    }


    @Override
    public Node<T> search(T value) throws EmptyTreeException {
        checkWhetherTreeIsEmpty();
        return searchRecursive(this.root, value);
    }

    private Node<T> searchRecursive(Node<T> node, T value) {
        if (node == null)
            return null;
        if (node.getInfo() == value)
            return node;
        else if (node.getInfo().compareTo(value) > 0)
            return searchRecursive(node.getLeftChild(), value);
        else
            return searchRecursive(node.getRightChild(), value);
    }

    @Override
    public void insert(T[] elements) {
        if (elements == null)
            throw new IllegalArgumentException("elements must be not null");
        for (T t : elements)
            this.insert(t);
    }

    @Override
    public void insert(T element) {
        Node<T> toInsert = new Node<>(element);
        if (this.isEmpty())
            this.root = toInsert;
        else
            insertRecursive(this.root, toInsert);
    }

    protected Node<T> insertRecursive(Node<T> node, Node<T> toInsert) {
        if (node == null)
            node = toInsert;
        else if (toInsert.getInfo().compareTo(node.getInfo()) < 0)
            node.setLeftChild(insertRecursive(node.getLeftChild(), toInsert));
        else
            node.setRightChild(insertRecursive(node.getRightChild(), toInsert));
        return node;
    }

    public void clean() {
        if (this.root != null)
            this.root = null;
    }

    public void delete(T element) {
         if (this.search(element) == null)
             throw new ElementDoesNotExistException();
        deleteRecursive(this.root, element);
    }

    protected Node<T> deleteRecursive(Node<T> node, T element) {
        if (node == null)
            return null;
        else if (node.getInfo().compareTo(element) > 0)
            node.setLeftChild(deleteRecursive(node.getLeftChild(), element));
        else if (node.getInfo().compareTo(element) < 0)
            node.setRightChild(deleteRecursive(node.getRightChild(), element));
        else { //We have found the wanted element...
            if (node.getLeftChild() == null && node.getRightChild() == null) //It has no children...
                node = null;
             else if (node.getLeftChild() == null) //It has only one child...
                node = node.getRightChild();
             else if (node.getRightChild() == null) //It has only one child...
                 node = node.getLeftChild();
             else { //It has two children...
                 Node<T> temp = findMin(node.getRightChild()); //Find the successor of the element to be deleted.
                 node.setInfo(temp.getInfo());
                 node.setRightChild(deleteRecursive(node.getRightChild(), temp.getInfo()));
            }
        }
        return node;
    }

    private Node<T> findMin(Node<T> node) {
        if (node.getLeftChild() == null)
            return node;
        else
            return findMin(node.getLeftChild());
    }
}
