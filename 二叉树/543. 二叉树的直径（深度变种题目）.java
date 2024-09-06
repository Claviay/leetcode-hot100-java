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
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }
    public int depth(TreeNode node) {
        if (node == null) {
            return 0; // 访问到空节点了，返回0
        }
        int L = depth(node.left); // 左儿子为根的子树的深度
        int R = depth(node.right); // 右儿子为根的子树的深度
        /*
二叉树的直径是树中任意两个节点之间的最长路径。路径可以通过根节点，也可以不经过根节点。
这里需要注意的是，路径中的长度是由边的数量决定的，而不是由节点的数量决定的。

L 是当前节点的左子树的最大深度，
即从当前节点向下走到左子树最深处的节点的路径长度（节点数 - 1）。

R 是当前节点的右子树的最大深度，
同样是从当前节点向下走到右子树最深处的节点的路径长度（节点数 - 1）。
        */
        ans = Math.max(ans, L+R+1); // 计算d_node即L+R+1 并更新ans
        return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
    }
}
