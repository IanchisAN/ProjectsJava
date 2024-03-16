package isp.lab3.exercise1;

public class Tree {
    private int height;

    public Tree(int height) {
        this.height = height;
    }

    public int grow(int meters) {
        if (meters >= 1) {
            this.height += meters;
        }
        return this.height;
    }
@Override
    public String toString() {
        return "Height of the tree: " + this.height + " meters.";
    }
    public static void main(String[] args) {
        Tree tree2 = new Tree(15);
        System.out.println(tree2.toString());
        tree2.grow(5);
        System.out.println(tree2.toString());
    }
}

