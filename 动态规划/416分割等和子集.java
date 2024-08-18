class Solution {
    public boolean canPartition(int[] nums) {
        // 计算数组的总和
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }

        // 如果总和为奇数，则无法分割成两个和相等的子集
        if (sum % 2 != 0) {
            return false;
        }

        // 将总和减半，因为我们要找到一个子集，其和等于总和的一半
        sum /= 2;

        // 初始化动态规划数组 dp，长度为 sum+1
        // dp[j] 表示是否能用数组中的某些元素组合成和为 j 的子集
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true; // 和为 0 的子集总是可以通过选择空集来实现

        // 初始化一个辅助变量 s2，表示当前可能的最大子集和
        int s2 = 0;




      
        // 遍历数组中的每一个元素
        for (int x : nums) {
            // 更新当前可能的最大子集和
            s2 = Math.min(s2 + x, sum);
 
            // 从后向前更新动态规划数组 dp
            for (int j = s2; j >= x; j--) {
                // 如果 dp[j - x] 为 true，说明存在一个子集和为 j - x
                // 那么加上 x 就能构成和为 j 的子集
                dp[j] = dp[j] || dp[j - x];
            }
        }



      

        // 返回 dp[sum]，判断是否能找到一个子集的和为 sum
        return dp[sum];
    }
}
