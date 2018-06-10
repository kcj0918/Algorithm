package dfs.searchDirection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Tree T = new Tree(4);
        T.left = new Tree(5);
        T.left.left = new Tree(4);
        T.left.left.left = new Tree(5);
        T.right = new Tree(6);
        T.right.left = new Tree(1);
        T.right.right = new Tree(6);
        int result = solution(T);
        System.out.println(result);
    }

    static int result = 0;

    static int solution(Tree T) {
        Set<Integer> mySet = new HashSet<>();
        List<Integer> myArray = new ArrayList<>();
        preOrderTraverse(T, mySet, myArray);
        return result;
    }

    static void preOrderTraverse(Tree root, Set mySet, List<Integer> myArray) {
        if (root != null) {
            myArray.add(root.data);
            if (root.left != null) {
                preOrderTraverse(root.left, mySet, myArray);
            }
            if (root.right != null) {
                preOrderTraverse(root.right, mySet, myArray);
            }
            if (root.left == null && root.right == null) {
                mySet.clear();
                for (int data : myArray) {
                    mySet.add(data);
                }
                int setSize = mySet.size();
                if (result < setSize) {
                    result = setSize;
                }
            }
            myArray.remove(myArray.size() - 1);
        }
    }
}
