class Solution {
    // 最长公共子序列
    // O(mn)
    public int longestCommonSubsequence(String text1, String text2) {
        // String转化成字符数组，使用toCharArray
        // 将text2转换为字符数组，便于逐个字符比较
        char[] array2 = text2.toCharArray();

        // 获取text2的长度
        int text2Len = array2.length;

        // 初始化一个长度为m+1的数组f，用于存储动态规划状态
        // dp[j + 1] 表示的是 text1 的当前前缀与 text2 的前缀 t[0...j] 的 LCS 长度。
        int[] dp = new int[text2Len + 1];

        // 遍历text1中的每个字符
        for (char x : text1.toCharArray()) {
            // 初始化pre为0，用于保存上一轮循环中的f[j + 1]的值
            for (int j = 0, pre = 0; j < text2Len; ++j) {

                // 暂存当前f[j + 1]的值，因为在更新f[j + 1]时需要使用它
                int tmp = dp[j + 1];

                // 动态规划状态转移方程
                // 如果x等于t[j]，说明当前字符匹配，那么f[j + 1] = pre + 1（pre是f[j]的值）
                // 否则，dp[j + 1] = max(dp[j + 1], dp[j])，即不匹配时，选取当前f[j + 1]和f[j]中的较大者
                dp[j + 1] = x == array2[j] ? pre + 1 : Math.max(dp[j + 1], dp[j]);

                // 将tmp赋给pre，以供下一次循环使用
                // 这个是变化前的dp[j + 1]，而不是变化后的
                pre = tmp;
            }
        }

        // 返回数组f的最后一个值，即最长公共子序列的长度
        return dp[text2Len];
    }
}
