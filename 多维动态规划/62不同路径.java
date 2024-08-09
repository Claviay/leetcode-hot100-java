/*
动态规划

边界只能延伸一种状态（因为只能向下和向右）
其他的则是dp[i][j] = dp[i-1][j] + dp[i][j-1];
 */
class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 1 && n == 1) return 1;

        int[][] dp = new int[m+1][n+1];
        dp[1][1] = 1;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(i == 1 && j>=2){
                    dp[i][j] = 1;
                }
                else if(i>=2 && j==1){
                    dp[i][j] = 1;
                }
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        System.out.println(new Solution().uniquePaths(m, n));
    }
}
