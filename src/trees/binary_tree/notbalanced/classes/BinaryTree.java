package trees.binary_tree.notbalanced.classes;

import trees.binary_tree.notbalanced.exceptions.*;

public class BinaryTree {
    private Node root;
    public static final int IN_ORDER = 0, POSTFIX = 1, PREFIX = -1, IN_LEVEL = 2;

    public BinaryTree() {}

    public BinaryTree(int value) {
        this.root = new Node(value);
    }

    public Node getRoot() {
        return this.root;
    }


    public boolean isEmpty() {
        return this.root == null;
    }

    public int size() {
        Counter counter = new Counter();
        count(counter, this.root);
        return counter.getNumber();
    }

    private void count(Counter counter, Node root) {
        if (root == null)
            return;
        counter.increment();
        count(counter, root.getRightChild());
        count(counter, root.getLeftChild());
    }

    public void print() {
        checkWhetherTreeIsEmpty();
        printInOrder(this.root);
    }

    public void print(int mode) {
        checkWhetherTreeIsEmpty();
        switch(mode) {
            case BinaryTree.IN_ORDER -> printInOrder(this.root);
            case BinaryTree.POSTFIX -> printPostfix(this.root);
            case BinaryTree.PREFIX -> printPrefix(this.root);
            case BinaryTree.IN_LEVEL -> printInLevel(this.root);
            default -> throw new IllegalArgumentException("unknown mode " + mode + " for printing");
        }
    }

    private void checkWhetherTreeIsEmpty() throws EmptyTreeException {
        if (isEmpty())
            throw new EmptyTreeException();
    }

    private void printInOrder(Node aNode) {
        if (aNode == null)
            return;
        printInOrder(aNode.getLeftChild());
        System.out.println(aNode.getInfo());
        printInOrder(aNode.getRightChild());
    }

    private void printPostfix(Node aNode) {
        if (aNode == null)
            return;
        printPostfix(aNode.getRightChild());
        printPostfix(aNode.getLeftChild());
        System.out.println(aNode.getInfo());
    }

    private void printPrefix(Node aNode) {
        if (aNode == null)
            return;
        System.out.println(aNode.getInfo());
        printPrefix(aNode.getLeftChild());
        printPrefix(aNode.getRightChild());
    }

    private void printInLevel(Node aNode) {
        System.out.println("Not implemented yet");
    }

    public Node search(int value) {
        checkWhetherTreeIsEmpty();
        return searchRecursive(this.root, value);
    }

    private Node searchRecursive(Node node, int value) {
        if (node == null)
            return null;
        if (node.getInfo() == value)
            return node;
        else if (node.getInfo() > value)
            return searchRecursive(node.getLeftChild(), value);
        else
            return searchRecursive(node.getRightChild(), value);
    }

    public void insert(int[] elements) {
        if (elements == null)
            throw new IllegalArgumentException("numbers must be not null");
        for (int i : elements)
            this.insert(i);
    }

    public void insert(int element) {
        Node toInsert = new Node(element);
        if (isEmpty())
            this.root = toInsert;
        else
            insertRecursive(this.root, toInsert);
    }

    protected Node insertRecursive(Node root, Node toInsert) {
        if (root == null)
            root = toInsert;
        else if (toInsert.getInfo() < root.getInfo())
            root.setLeftChild(insertRecursive(root.getLeftChild(), toInsert));
        else
            root.setRightChild(insertRecursive(root.getRightChild(), toInsert));
        return root;
    }

    public void clean() {
        if (this.root != null)
            this.root = null;
    }

    public void delete(int element) {
         if (search(element) == null)
             throw new ElementDoesNotExistException(element);
        deleteRecursive(this.root, element);
    }

    protected Node deleteRecursive(Node root, int element) {
        if (root == null)
            return null;
        else if (root.getInfo() > element)
            root.setLeftChild(deleteRecursive(root.getLeftChild(), element));
        else if (root.getInfo() < element)
            root.setRightChild(deleteRecursive(root.getRightChild(), element));
        else { //We have found the wanted element...
            if (root.getLeftChild() == null && root.getRightChild() == null) //It has no children...
                root = null;
             else if (root.getLeftChild() == null) //It has only one child...
                root = root.getRightChild();
             else if (root.getRightChild() == null) //It has only one child...
                 root = root.getLeftChild();
             else { //It has two children...
                 Node temp = findMin(root.getRightChild()); //Find the successor of the element to be deleted.
                 root.setInfo(temp.getInfo());
                 root.setRightChild(deleteRecursive(root.getRightChild(), temp.getInfo()));
            }
        }
        return root;
    }

    private Node findMin(Node root) {
        if (root.getLeftChild() == null)
            return root;
        else
            return findMin(root.getLeftChild());
    }
}
