/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
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

    int res = 0;  // 用于存储结果，即第 k 小的值
    int k;  // 计数器，表示需要找到第 k 小的节点

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;  // 初始化 k
        dfs(root);   // 调用深度优先搜索 (DFS) 方法
        return res;  // 返回结果
    }

    void dfs(TreeNode root) {
        if (root == null) {  // 递归的终止条件
            return;
        }

        dfs(root.left);  // 先遍历左子树

        // 访问当前节点
        k--;  // 每次访问一个节点时，减少 k
        if (k == 0) {  // 当 k 减少到 0 时，说明当前节点就是第 k 小的节点
            res = root.val;  // 记录结果
            return;  // 由于找到了结果，可以提前结束递归
        }

        dfs(root.right);  // 最后遍历右子树
    }
}
