class Solution {
    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(nums, left, right);
            quickSort(nums, left, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right]; // 选择最右边的元素作为基准
        int i = left - 1; // i 指向左边部分的最后一个元素

        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j); // 把小于等于 pivot 的元素移到左边部分
            }
        }

        swap(nums, i + 1, right); // 最后将 pivot 放到正确的位置
        return i + 1; // 返回 pivot 的最终位置
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 6, 8, 10, 1, 2, 1};
        solution.quickSort(nums, 0, nums.length - 1);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
