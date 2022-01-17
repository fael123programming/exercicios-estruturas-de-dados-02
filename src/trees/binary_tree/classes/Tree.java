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

    public Node delete(int value) {
        return deleteRecursive(this.root, value);
    }

    private Node deleteRecursive(Node root, int value) {
        if (root == null)
            return null;
        else if (root.getInfo() > value)
            root.setLeftChild(deleteRecursive(root.getLeftChild(), value));
        else if (root.getInfo() < value)
            root.setRightChild(deleteRecursive(root.getRightChild(), value));
        else if (root.getRightChild() == null && root.getLeftChild() == null)
            root = null;
        else if (root.getLeftChild() == null) {
            Node newNode = root;
            root = root.getRightChild();
        } else if (root.getRightChild() == null) {
            Node newNode = root;
            root = root.getLeftChild();
        } else {
            Node newNode = root.getLeftChild();
            while (newNode.getRightChild() != null)
                newNode = newNode.getRightChild();
            root.setInfo(newNode.getInfo());
            newNode.setInfo(value);
            root.setLeftChild(deleteRecursive(root.getLeftChild(), value));
        }
        return root;
    }
}
