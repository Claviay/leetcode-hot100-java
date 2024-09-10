/*
使用前缀和的方法可以解决这个问题，因为我们需要找到和为k的连续子数组的个数。
通过计算前缀和，我们可以将问题转化为求解两个前缀和之差等于k的情况。

假设数组的前缀和数组为prefixSum，其中prefixSum[i]表示从数组起始位置到第i个位置的元素之和。
那么对于任意的两个下标i和j（i < j），如果prefixSum[j] - prefixSum[i] = k，
即从第i个位置到第j个位置的元素之和等于k，那么说明从第i+1个位置到第j个位置的连续子数组的和为k。

通过遍历数组，计算每个位置的前缀和，并使用一个哈希表来存储每个前缀和出现的次数。
在遍历的过程中，我们检查是否存在prefixSum[j] - k的前缀和，
如果存在，说明从某个位置到当前位置的连续子数组的和为k，我们将对应的次数累加到结果中。

这样，通过遍历一次数组，我们可以统计出和为k的连续子数组的个数，并且时间复杂度为O(n)，其中n为数组的长度。
O(n)

sum(i,j)=prefixSum[j]−prefixSum[i−1]
*/
class Solution {
    public static int subarraySum(int[] nums, int k) {
        // 初始化计数器，sum 表示当前的前缀和
        int count = 0;
        int sum = 0;

        // 用哈希表存储前缀和出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // 前缀和为 0 的情况出现了一次

        // 遍历数组，逐步累加前缀和并查找是否存在和为 k 的子数组
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]; // 累加当前元素的值到前缀和

            // 检查是否存在前缀和为 sum - k，如果存在则说明有子数组和为 k
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k); // 累加找到的子数组数量
            }

            // 将当前前缀和加入哈希表，记录它出现的次数
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        // 返回子数组和为 k 的个数
        return count;
    }
}
