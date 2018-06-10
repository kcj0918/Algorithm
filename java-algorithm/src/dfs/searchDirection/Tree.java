package dfs.searchDirection;

public class Tree {
    public int data;
    public Tree left;
    public Tree right;

    public Tree() {
        this.left = null;
        this.right = null;
    }
    public Tree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
