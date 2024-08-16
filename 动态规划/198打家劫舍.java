import java.util.*;

class Solution {
    public int rob(int[] nums) {
        int previous = 0;
        int current = 0;

        // 每次循环，计算“偷到当前房子为止的最大金额”
        for (int item : nums) {
            // 循环开始时，current 表示 dp[k-1]，previous 表示 dp[k-2]
            // dp[k] = max{ dp[k-1], dp[k-2] + item }
            int temp = Math.max(current, previous + item); 
            
            previous = current;
            current = temp;
            // 循环结束时，current 表示 dp[k]，previous 表示 dp[k-1]
        }

        return current;
    }
}
