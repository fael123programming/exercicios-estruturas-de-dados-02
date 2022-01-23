package trees.binary_tree.tests;

import trees.binary_tree.classes.*;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree(new Node(12));
        tree.insert(5);
        tree.insert(3);
        tree.insert(1);
        tree.insert(7);
        tree.insert(9);
        tree.insert(15);
        tree.insert(17);
        tree.insert(13);
        System.out.println("Elements: ");
        tree.print();
        System.out.println("-----------");
        System.out.println("Size: " + tree.size());
        if(tree.delete(15))
            System.out.println("15 deleted...");
        if (tree.delete(13))
            System.out.println("13 deleted...");
        System.out.println("Size: " + tree.size());
        System.out.println("Elements: ");
        tree.print();
        System.out.println("-----------");
    }
}
