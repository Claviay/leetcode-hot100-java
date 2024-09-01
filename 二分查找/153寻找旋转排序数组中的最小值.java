class Solution {

    public int findMin(int[] nums) {
        int n = nums.length;
        int left = -1; // 左边界 (初始为 -1)
        int right = n - 1; // 右边界 (初始为 n-1)

        // 开区间 (left, right)，区间不为空
        while (left + 1 < right) {
            int mid = left + (right - left) / 2; // 计算中间点

            // 判断中间点值与数组最后一个元素的关系
            if (nums[mid] < nums[n - 1]) {
                right = mid; // 右边缩短
            } else {
                left = mid; // 左边缩短
            }
        }

        // 最小值在 right 位置
        return nums[right];
    }
}
