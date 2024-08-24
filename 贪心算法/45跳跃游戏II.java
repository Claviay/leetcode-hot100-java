class Solution {
    public int jump(int[] nums) {
        int n = nums.length;      // 数组的长度
        int[] dp = new int[n];     // 动态规划数组，用于存储到达每个位置的最少跳跃次数

        // 从位置 1 开始遍历每个元素，初始时 j = 0
        for (int i = 1, j = 0; i < n; i++) {
            // 内部循环，确保我们找到一个位置 j，使得从 j 位置跳跃后能到达 i 位置
            while (j + nums[j] < i) j++;  // 如果当前 j 位置的跳跃范围不足以覆盖 i 位置，j 向右移动

            // 更新 dp[i]，表示从起点到达位置 i 需要的最少跳跃次数
            dp[i] = dp[j] + 1;
        }

        // 返回到达最后一个位置（即 n-1）所需的最少跳跃次数
        return dp[n - 1];
    }
}
