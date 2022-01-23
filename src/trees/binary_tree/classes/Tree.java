package trees.binary_tree.classes;

public class Tree {
    private Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return this.root;
    }

    public void setRoot(Node root) {
        this.root = root;
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
        else
            counter.incrementNumber();
        count(counter, root.getRightChild());
        count(counter, root.getLeftChild());
    }

    public void print() {
        printRecursive(this.root);
    }

    private void printRecursive(Node aNode) {
        if (aNode == null)
            return;
        printRecursive(aNode.getLeftChild());
        System.out.println(aNode.getInfo());
        printRecursive(aNode.getRightChild());
    }

    public Node search(int value) {
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

    public void insert(int info) {
        insertRecursive(this.root, new Node(info));
    }

    private Node insertRecursive(Node root, Node toInsert) {
        if (root == null)
            root = toInsert;
        else if (toInsert.getInfo() < root.getInfo())
            root.setLeftChild(insertRecursive(root.getLeftChild(), toInsert));
        else
            root.setRightChild(insertRecursive(root.getRightChild(), toInsert));
        return root;
    }

    public boolean delete(int value) {
        if (isEmpty())
            return false;
         if (search(value) == null)
             return false; //Element does not exist...
        deleteRecursive(this.root, value);
        return true; //Element does exist and was removed, presumably...
    }

    private Node deleteRecursive(Node root, int value) {
        if (root == null)
            return null;
        else if (root.getInfo() > value)
            root.setLeftChild(deleteRecursive(root.getLeftChild(), value));
        else if (root.getInfo() < value)
            root.setRightChild(deleteRecursive(root.getRightChild(), value));
        else { //We have found the wanted element...
            if (root.getLeftChild() == null && root.getRightChild() == null) //It has no children...
                root = null;
             else if (root.getLeftChild() == null) //It has only one child...
                root = root.getRightChild();
             else if (root.getRightChild() == null) //It has only one child...
                 root = root.getLeftChild();
             else { //It has two children...
                 Node temp = findMin(root.getRightChild());
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
