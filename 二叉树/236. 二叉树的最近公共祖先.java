class Solution {
    private int ans = Integer.MIN_VALUE; // 初始化全局变量，记录当前找到的最大路径和，初值设为最小整数

    public int maxPathSum(TreeNode root) {
        dfs(root); // 对树进行深度优先搜索
        return ans; // 返回找到的最大路径和
    }

    // 定义 dfs 函数：对每个节点，返回从该节点出发向下的最大链和（如果为负则返回0）
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0; // 如果当前节点是空的，返回 0，因为空节点不会对路径和有贡献
        }

        int lVal = dfs(node.left); // 递归计算左子树的最大链和
        int rVal = dfs(node.right); // 递归计算右子树的最大链和

        // 更新全局变量 ans：当前节点作为路径的一部分，可能连接左子树和右子树形成一个新的路径，
        // 这时路径的和为：左子树最大链和 + 当前节点值 + 右子树最大链和。
        // 我们要用这个和去更新当前的最大路径和。
        ans = Math.max(ans, lVal + rVal + node.val);

        // 返回当前子树中的最大链和（要么连接左子树，要么连接右子树，或者不连接任何子树），
        // 同时如果链和为负值，直接返回0（表示不选择这条路径）。
        return Math.max(Math.max(lVal, rVal) + node.val, 0);
    }
}
