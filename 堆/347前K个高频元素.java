import java.util.*;
// 线性

class Solution {
    public static int[] topKFrequent(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int[] ans = new int[k];

        // 找到数组中的最大值和最小值
        for (int i : nums) {
            max = i > max ? i : max; // 更新最大值
            min = i < min ? i : min; // 更新最小值
        }

        // 创建一个桶数组，用于记录每个数字出现的频率
        int[] buckets = new int[max - min + 1];
        for (int num : nums) {
            buckets[num - min]++; // 将数字映射到桶数组中，并增加频率
        }

        // 找到桶数组中的最大频率
        int maxF = 0;
        for (int bucket : buckets) {
            maxF = bucket > maxF ? bucket : maxF; // 更新最大频率
        }

        int index = 0; // 结果数组的索引
        // 找到出现频率最高的 k 个数字
        while (index < k) {
            for (int i = 0; i < buckets.length; i++) {
                if (maxF == buckets[i]) {
                    ans[index] = i + min; // 将数字从桶数组映射回原数组的值
                    index++;              // 更新结果数组的索引
                }
            }
            maxF--; // 减少最大频率，继续查找下一个频率最高的数字
        }

        return ans; // 返回结果数组
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = solution.topKFrequent(nums, k);

        // 输出结果
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
