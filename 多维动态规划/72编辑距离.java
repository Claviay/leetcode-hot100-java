/*
重点是状态转移方程作为动态规划
dp[i][j] 指的是从text1的i位置！！！转移！！！到text2的j位置

当 word1[i] == word2[j]，dp[i][j] = dp[i-1][j-1]；（相等了就不用更改了）
当 word1[i] != word2[j]，dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1

其中，dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int word1Length = word1.length();
        int word2Length = word2.length();

        char[] array1 = new char[word1Length+1];
        char[] array2 = new char[word2Length+1];
        for(int i=0; i<word1Length; i++){
            array1[i+1] = word1.charAt(i);
        }
        for(int i=0; i<word2Length; i++){
            array2[i+1] = word2.charAt(i);
        }

        // 状态转移方程
        int[][] dp = new int[array1.length+1][array2.length+1];

        // 初始点是0
        dp[0][0] = 0;

        // 第1列
        for(int i=1; i<array1.length; i++){
            int j = 0;
            dp[i][j] = dp[i-1][j] + 1;
        }

        // 第1行
        for(int j=1; j<array2.length; j++){
            int i = 0;
            dp[i][j] = dp[i][j-1] + 1;
        }

        // 开始状态转移
        for(int i=1; i<=array1.length; i++){
            for(int j=1; j<=array2.length; j++){
                if (array1[i-1] == array2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
            }
        }

        return dp[array1.length][array2.length];
    }
}
