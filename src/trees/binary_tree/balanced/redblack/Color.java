package trees.binary_tree.balanced.redblack;

public enum Color {
    RED(1), BLACK(2);

    private final int id;

    Color(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
