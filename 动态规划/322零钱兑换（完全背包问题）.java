import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        // 创建一个长度为 amount + 1 的数组 dp，用于存储每个金额的最小硬币数
        int[] dp = new int[amount + 1];

        // 将数组初始化为一个很大的值，表示尚未计算
        Arrays.fill(dp, Integer.MAX_VALUE / 2);

        // 0 的最小硬币数是 0
        dp[0] = 0;

        // 遍历每一种硬币面额
        for (int x : coins) {
            // 更新每个金额 c 的最小硬币数
            for (int c = x; c <= amount; c++) {
                dp[c] = Math.min(dp[c], dp[c - x] + 1);
            }
        }

        // 获取金额 amount 的最小硬币数
        int ans = dp[amount];

        // 如果最小硬币数仍然是初始的很大值，则说明无法组合出这个金额，返回 -1
        return ans < Integer.MAX_VALUE / 2 ? ans : -1;
    }
}
