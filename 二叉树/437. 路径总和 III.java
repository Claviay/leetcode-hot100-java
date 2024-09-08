import java.util.*;
class Solution {
    private int ans; // 记录满足条件的路径数量
    private int target;
    public int pathSum(TreeNode root, int targetSum) {
        // 创建哈希表，键为前缀和，值为该前缀和出现的次数
        this.target = targetSum;
        Map<Long, Integer> cnt = new HashMap<>();

        // 初始化前缀和为0的情况（从根节点到当前路径和为0的情况出现了一次）
        cnt.put(0L, 1);

        // 深度优先搜索（DFS）遍历树，开始时路径和为0
        dfs(root, 0, cnt);

        // 返回符合条件的路径数量
        return ans;
    }

    /**
     * 深度优先搜索遍历二叉树
     *
     * @param node 当前遍历的节点
     * @param s 当前路径的前缀和
     * @param targetSum 目标和
     * @param cnt 记录前缀和出现次数的哈希表
     */
    private void dfs(TreeNode node, long s, Map<Long, Integer> cnt) {
        if (node == null) {
            return; // 如果当前节点为空，直接返回
        }

        // 更新当前路径的前缀和
        s += node.val;

        // 检查是否存在满足条件的前缀和，使得从某个之前的节点到当前节点的路径和为 target
        ans += cnt.getOrDefault(s - target, 0);

        // 将当前前缀和加入哈希表，记录它出现的次数
        // cnt.put(s, cnt.getOrDefault(s, 0) + 1);  // 同样可以
        cnt.merge(s, 1, Integer::sum);

        // 递归遍历左子树
        dfs(node.left, s, cnt);

        // 递归遍历右子树
        dfs(node.right, s, cnt);

        // 回溯：递归返回时，减去当前路径和的出现次数
        // cnt.put(s, cnt.getOrDefault(s, 0) - 1);  // 同样可以
        cnt.merge(s, -1, Integer::sum); // 恢复现场
    }
}
