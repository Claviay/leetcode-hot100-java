/*
荷兰国旗问题


*/


class Solution {
    public void sortColors(int[] nums) {
        int n_0 = 0;
        int n_1 = 0;

        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];  // 暂时取出这个nums[i]

            nums[i] = 2;

            if (temp < 2) {
                nums[n_1++] = 1;
            }

            if (temp < 1) {
                nums[n_0++] = 0;
            }

        }
    }
}
