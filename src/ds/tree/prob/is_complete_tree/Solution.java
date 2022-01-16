package ds.tree.prob.is_complete_tree;

import ds.tree.TreeNode;
import ds.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if(root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean halfFilled = false;
        while(!queue.isEmpty()) {
            int currSize = queue.size();
            while (currSize > 0){
                TreeNode removedNode = queue.remove();
                if(removedNode.left != null && !halfFilled)
                    queue.add(removedNode.left);
                else if(removedNode.left == null && !halfFilled)
                    halfFilled = true;
                else if(removedNode.left != null && halfFilled)
                    return false;

                if(removedNode.right != null && !halfFilled)
                    queue.add(removedNode.right);
                else if(removedNode.right == null && !halfFilled)
                    halfFilled = true;
                else if(removedNode.right != null && halfFilled)
                    return false;

                currSize--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);

        Solution solution = new Solution();
        boolean var = solution.isCompleteTree(root);
        System.out.println(var);
    }
}
