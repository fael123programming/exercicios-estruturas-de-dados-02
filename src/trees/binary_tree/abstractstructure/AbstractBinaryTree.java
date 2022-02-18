package trees.binary_tree.abstractstructure;

import trees.binary_tree.classes.BinaryTree;
import trees.extra.counter.Counter;
import trees.extra.exceptions.ElementDoesNotExistException;
import trees.extra.exceptions.EmptyTreeException;

public abstract class AbstractBinaryTree<T extends Comparable<T>> {
    protected AbstractNode<T> root;
    public static final int IN_ORDER = 0, POSTFIX = 1, PREFIX = -1;

    public AbstractBinaryTree(T rootData) {
        this.root = this.castDataToNodeImplementation(rootData);
    }

    public AbstractBinaryTree() {}

    public AbstractNode<T> getRoot() {
        return this.root;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public int nodes() {
        if (this.isEmpty())
            return 0;
        Counter counter = new Counter();
        this.count(counter, this.root);
        return counter.getNumber();
    }

    private void count(Counter counter, AbstractNode<T> root) {
        if (root == null)
            return;
        counter.increment();
        this.count(counter, root.getRightChild());
        this.count(counter, root.getLeftChild());
    }

    public void print() throws EmptyTreeException {
        this.checkTreeIsEmpty();
        this.printInOrder(this.root);
    }

    public void print(int mode) throws EmptyTreeException, IllegalArgumentException {
        this.checkTreeIsEmpty();
        switch(mode) {
            case BinaryTree.IN_ORDER -> printInOrder(this.root);
            case BinaryTree.POSTFIX -> printPostfix(this.root);
            case BinaryTree.PREFIX -> printPrefix(this.root);
            default -> throw new IllegalArgumentException("unknown mode " + mode + " for printing");
        }
    }

    private void printInOrder(AbstractNode<T> node) {
        if (node == null)
            return;
        this.printInOrder(node.getLeftChild());
        System.out.println(node);
        this.printInOrder(node.getRightChild());
    }

    private void printPostfix(AbstractNode<T> node) {
        if (node == null)
            return;
        this.printPostfix(node.getRightChild());
        this.printPostfix(node.getLeftChild());
        System.out.println(node.getData());
    }

    private void printPrefix(AbstractNode<T> node) {
        if (node == null)
            return;
        System.out.println(node.getData());
        this.printPrefix(node.getLeftChild());
        this.printPrefix(node.getRightChild());
    }

    private void checkTreeIsEmpty() throws EmptyTreeException {
        if (this.isEmpty())
            throw new EmptyTreeException();
    }

    private void checkNull(Object obj) throws IllegalArgumentException {
        if (obj == null)
            throw new IllegalArgumentException("null argument passed");
    }

    public AbstractNode<T> search(T data) throws EmptyTreeException, IllegalArgumentException {
        this.checkTreeIsEmpty();
        this.checkNull(data);
        return this.searchRecursive(this.root, data);
    }

    private AbstractNode<T> searchRecursive(AbstractNode<T> node, T data) {
        if (node == null)
            return null;
        if (node.getData() == data)
            return node;
        else if (node.getData().compareTo(data) > 0)
            return this.searchRecursive(node.getLeftChild(), data);
        else
            return this.searchRecursive(node.getRightChild(), data);
    }

    public void insert(T[] elements) throws IllegalArgumentException {
        this.checkNull(elements);
        for (T t : elements) {
            this.checkNull(t);
            this.insert(t);
        }
    }

    public void insert(T data) {
        this.checkNull(data);
        this.root = this.insertRecursive(this.root, data);
    }

    protected abstract AbstractNode<T> insertRecursive(AbstractNode<T> node, T data);

    protected abstract AbstractNode<T> castDataToNodeImplementation(T data);

    public void delete(T data) {
        if (!this.dataExists(data))
            throw new ElementDoesNotExistException();
        this.deleteRecursive(this.root, data);
    }

    protected abstract AbstractNode<T> deleteRecursive(AbstractNode<T> node, T data);

    public boolean dataExists(T data) throws EmptyTreeException, IllegalArgumentException {
        return this.search(data) != null;
    }

    protected T getMin(AbstractNode<T> node) {
        this.checkNull(node);
        while(node.hasLeftChild())
            node = node.getLeftChild();
        return node.getData();
    }

    protected T getMax(AbstractNode<T> node) {
        this.checkNull(node);
        while (node.hasRightChild())
            node = node.getRightChild();
        return node.getData();
    }

    public T getMax() throws EmptyTreeException {
        this.checkTreeIsEmpty();
        return this.getMax(this.root);
    }

    public T getMin() throws EmptyTreeException {
        this.checkTreeIsEmpty();
        return this.getMin(this.root);
    }

    public void clean() {
        if (this.root != null)
            this.root = null;
    }
}
