import java.util.Arrays;

class Solution {
    public int numSquares(int n) {
        // 创建一个长度为 n + 1 的数组 dp，用于存储每个数字对应的最小完全平方数个数
        int[] dp = new int[n + 1];

        // 将数组初始化为 Integer.MAX_VALUE，表示尚未计算
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // 从 1 到 sqrt(n) 遍历每一个完全平方数
        for (int i = 1; i * i <= n; i++) {
            int square = i * i; // 当前完全平方数
            // 从当前完全平方数开始，更新每个可能的数字
            for (int j = square; j <= n; j++) {
                // 更新 dp[j] 的值

                //-------------状态转移方程
                dp[j] = Math.min(dp[j], dp[j - square] + 1);
                //-------------状态转移方程

            }
        }
        // 返回 dp[n]，即表示 n 的最小完全平方数个数
        return dp[n];
    }
}
