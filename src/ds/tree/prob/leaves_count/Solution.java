package ds.tree.prob.leaves_count;

import ds.tree.TreeNode;

public class Solution {
    int countLeaves(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left == null && root.right ==null)
            return 1;
        else
            return countLeaves(root.left) + countLeaves(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);

        Solution solution = new Solution();
        int count = solution.countLeaves(root);
        System.out.println(count);
    }

}
