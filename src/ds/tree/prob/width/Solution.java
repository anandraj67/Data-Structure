package ds.tree.prob.width;

import ds.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int width(TreeNode root) {
        if (root ==  null)
            return 0;
        int width = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            width = Math.max(width, size);
            while (size > 0){
                TreeNode removedNode = queue.remove();
                if(removedNode.left != null){
                    queue.add(removedNode.left);
                }
                if(removedNode.right != null){
                    queue.add(removedNode.right);
                }
                size--;
            }
        }
        return width;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(6);

        Solution solution = new Solution();
        int width = solution.width(root);
        System.out.println(width);
    }
}
