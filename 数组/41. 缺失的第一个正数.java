public class Solution {

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        // Step 1: 放置每个正整数到正确的位置
        for (int i = 0; i < len; i++) {
            // 只有在值在有效范围内且值不在正确位置时才交换
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                // 交换 nums[i] 和 nums[nums[i] - 1]
                swap(nums, nums[i] - 1, i);
            }
        }

        // Step 2: 查找第一个缺失的正整数
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // Step 3: 如果所有位置都正确，返回 len + 1
        return len + 1;
    }

    // 辅助方法：交换数组中的两个元素
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
