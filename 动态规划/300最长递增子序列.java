/*
nlogn

动态规划+二分查找
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        // 创建一个数组 arr，用于存储当前的递增子序列
        int[] arr = new int[nums.length];
        arr[0] = nums[0]; // 初始化 arr，起始值为 nums 的第一个元素
        int arrLength = 1; // 用来记录 arr 中实际元素的个数

        // 遍历 nums 数组
        for (int i = 1; i < nums.length; i++) {
            // 如果当前数字比 arr 中的最后一个数字大，直接添加到 arr 的末尾
            if (nums[i] > arr[arrLength - 1]) {
                arr[arrLength] = nums[i];
                arrLength++;
            } else {
                // 否则，通过二分查找找到合适的位置进行替换
                int index = binarySearch(arr, 0, arrLength - 1, nums[i]);
                arr[index] = nums[i];
            }
        }
        // 返回最长递增子序列的长度
        return arrLength;
    }

    // 二分查找，找到 target 在 arr 中应该插入的位置
    private int binarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2; // 防止溢出的写法
            if (arr[mid] < target) {
                left = mid + 1; // target 在右半部分
            } else {
                right = mid - 1; // target 在左半部分或等于 mid
            }
        }
        return left; // 返回插入位置
    }
}
