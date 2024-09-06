/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;  // 当前节点的值
 *     TreeNode left;  // 左子树
 *     TreeNode right; // 右子树
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    // 计算二叉树的最大深度
    public int maxDepth(TreeNode root) {
        // 基线条件：如果当前节点为空，返回深度为0
        if (root == null) {
            return 0;
        } else {
            // 递归计算左子树的深度
            int leftHeight = maxDepth(root.left);
            // 递归计算右子树的深度
            int rightHeight = maxDepth(root.right);
            // 当前节点的深度为左右子树中较大的深度 + 1
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
