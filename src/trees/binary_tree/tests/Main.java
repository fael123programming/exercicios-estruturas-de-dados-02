package trees.binary_tree.tests;

import trees.binary_tree.classes.*;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree(new Node(10));
        tree.insert(20);
        tree.insert(0);
        tree.print();
        System.out.println("--------");
        Node deleted = tree.delete(10);
        System.out.println(deleted.getInfo());
    }
}
