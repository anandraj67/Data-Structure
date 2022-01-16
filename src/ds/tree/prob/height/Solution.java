package ds.tree.prob.height;

import ds.tree.Tree;
import ds.tree.TreeNode;

public class Solution {
    int height(TreeNode root) {
        if (root==null)
            return 0;
        else
            return Math.max(height(root.left), height(root.right))+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);

        Solution solution = new Solution();
        int height = solution.height(root);
        System.out.println(height);
    }
}
