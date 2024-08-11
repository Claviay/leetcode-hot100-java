/*
中心扩散的方法，其实做了很多重复计算。动态规划就是为了减少重复计算的问题。
动态规划听起来很高大上。其实说白了就是空间换时间，将计算结果暂存起来，避免重复计算。

我们用一个 boolean dp[l][r] 表示字符串从 i 到 j 这段是否为回文。
试想如果 dp[l][r]=true，我们要判断 dp[l-1][r+1] 是否为回文。
只需要判断字符串在(l-1)和（r+1)两个位置是否为相同的字符，是不是减少了很多重复计算。

进入正题，动态规划关键是找到初始状态和状态转移方程。
初始状态，l=r 时，此时 dp[l][r]=true。
状态转移方程，dp[l][r]=true 并且(l-1)和（r+1)两个位置为相同的字符，此时 dp[l-1][r+1]=true。
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int strLen = s.length();
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度

        boolean[][] dp = new boolean[strLen][strLen];

        for (int r = 1; r < strLen; r++) {  // 第2个~倒数第2个
            for (int l = 0; l < r; l++) {

                // 如果 这个两个位置相等&&两个位置足够近（可以中间单独两边相同）
                // 或者 这个两个位置相等&&前面那个状态是true
                if (s.charAt(l) == s.charAt(r) &&   (r - l <= 2 || dp[l + 1][r - 1])   ) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;

                    }
                }

            }

        }
        return s.substring(maxStart, maxEnd + 1);

    }
}
