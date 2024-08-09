/*
遍历数组：
对于每个元素 nums[i]，如果它没有在正确的位置上（即 nums[i] != i + 1），
则尝试将它放到正确的位置上。

检测重复数字：
如果发现 nums[nums[i] - 1] 已经等于 nums[i]，这
说明当前数字已经存在于数组中，因此这个数字就是重复的。

交换元素：
如果 nums[i] 没有在正确的位置上，并且该位置的数字与 nums[i] 不同，
则交换这两个数字。通过不断交换，最终每个数字应该都能放置到它正确的位置上，除非这个数字是重复的。
 */
class Solution {
    public static int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1) { // 如果这个数据不在正确位置
                if (nums[nums[i] - 1] == nums[i]) {  // 看看这个数据对应的正确位置是否已经有了

                    // 如果已经有了，那么说明找到重复的数字了
                    return nums[i];  
                }
                // 交换 nums[i] 和 nums[nums[i] - 1]
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        return -1;  // 没有找到重复的数字，通常情况下不应发生
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 2, 3, 4, 5, 6, 2, 7, 8, 9}));
    }
}
