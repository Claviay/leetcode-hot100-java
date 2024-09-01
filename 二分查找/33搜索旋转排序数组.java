public class Solution {
    public int search(int[] nums, int target) {
        int left = 0; // 左指针，初始化为数组的起始位置
        int right = nums.length - 1; // 右指针，初始化为数组的末尾位置

        // 当左指针小于或等于右指针时，继续循环
        while (left <= right) {
            int mid = left + (right - left) / 2; // 计算中间位置

            // 如果中间位置的元素等于目标值，返回该位置
            if (nums[mid] == target) {
                return mid;
            }

            // 判断左半部分是否有序
            if (nums[left] <= nums[mid]) {
                // 左半部分有序
                if (nums[left] <= target && target < nums[mid]) {
                    // 如果目标值在左半部分的范围内，更新右指针
                    right = mid - 1;
                } else {
                    // 否则，目标值在右半部分，更新左指针
                    left = mid + 1;
                }
            } else {
                // 右半部分有序
                if (nums[mid] < target && target <= nums[right]) {
                    // 如果目标值在右半部分的范围内，更新左指针
                    left = mid + 1;
                } else {
                    // 否则，目标值在左半部分，更新右指针
                    right = mid - 1;
                }
            }
        }

        // 如果循环结束仍未找到目标值，返回 -1
        return -1;
    }
}
