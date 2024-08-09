/*
先从最有右边开始，向左，找到下降点
从下降点，向右，找到大于下降点的最小的（但是也要大于下降点）的位置
交换上面两个位置
然后，下降点之后的所有元素reverse

 */

class Solution {
    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public void reverse(int[] nums, int l, int r) {
        // 记住标准是小于，不包含等于
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int right = len - 1;




        // 这里界限不是0
        while (right > 0 && nums[right] <= nums[right - 1]) {
            right--;
        }

        // 特殊处理，最大序列情况，然后，变成最小序列
        if (right == 0) {
            reverse(nums, 0, len - 1);
            return;
        }






        // 调整到下降的位置
        int left_target = right - 1;

        while (right <= len - 1 && nums[right] > nums[left_target]) {
            right++;
        }

        int right_target = right - 1;
        swap(nums, left_target, right_target);
        reverse(nums, left_target+1, len - 1);
    }
}
