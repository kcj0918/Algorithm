package tree;

import java.util.ArrayList;
import java.util.List;

public class PerfectBinaryTree {
    static int height;
    static int count = 0;
    static int result = 0;

    public static void main(String[] args) {
        Tree tree = new Tree(1);
        tree.left = new Tree(2);
        tree.left.right = new Tree(4);
        tree.right = new Tree(3);
        tree.right.left = new Tree(5);
        tree.right.right = new Tree(6);
        tree.right.left.left = new Tree(7);
        tree.right.left.right = new Tree(8);
        tree.right.right.left = new Tree(9);
        tree.right.right.right = new Tree(10);
        tree.right.right.right.left = new Tree(11);

//        Tree tree = new Tree(1);
//        tree.left = new Tree(2);
//        tree.right = new Tree(3);
//        tree.left.left = new Tree(4);
//        tree.left.right = new Tree(5);
//        tree.right.left = new Tree(6);
        height = treeHeight(tree);
        System.out.println(solution(tree));
    }

    static int solution(Tree root) {
        if (root != null) {
            if (root.left != null && root.right != null) {
                count++;
            }
            solution(root.left);
            solution(root.right);
        }
        List<Integer> array = new ArrayList<>();
        array.add(1);
        for (int i = 1; i < height - 1; i++) {
            array.add((array.get(i - 1) * 2) + 1);
        }
        for (int i = 1; i < array.size(); i++) {
            if (count >= array.get(i - 1) && count < array.get(i)) {
                result = array.get(i);
            }
        }
        return result;
    }

    static int treeHeight(Tree t) {
        if (t == null) {
            return 0;
        }
        return 1 + Math.max(treeHeight(t.left), treeHeight(t.right));
    }
}

class Tree {
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
