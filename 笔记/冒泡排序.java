class Solution {
    public void bubbleSort(int[] nums) {
        int n = nums.length;
        boolean swapped;

        // 外层循环控制遍历的次数
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // 内层循环从头开始遍历，逐个比较相邻元素
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    // 如果前面的元素比后面的元素大，则交换它们
                    swap(nums, j, j + 1);
                    swapped = true;
                }
            }

            // 如果没有发生交换，说明数组已经有序，可以提前退出
            if (!swapped) {
                break;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 6, 8, 10, 1, 2, 1};
        solution.bubbleSort(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
