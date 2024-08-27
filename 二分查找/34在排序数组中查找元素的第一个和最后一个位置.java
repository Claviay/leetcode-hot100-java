import java.util.*;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findLeft(nums, target);  // 查找左边界
        res[1] = findRight(nums, target); // 查找右边界
        return res;
    }

    // findLeft是和之前的找到对应的一样
    // 没有等号： if (nums[mid] < target)
    private int findLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // 检查左边界值是否等于目标值
        if (left <= nums.length - 1 && nums[left] == target) {
            return left;
        }
        return -1;
    }



    // 注意！！！这里有等号
    // if (nums[mid] <= target)这里有等号
    private int findRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 检查右边界值是否等于目标值
        if (right >= 0 && nums[right] == target) {
            return right;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] res1 = sol.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8); // [3, 4]
        int[] res2 = sol.searchRange(new int[]{1, 2, 3}, 1); // [0, 0]
        int[] res3 = sol.searchRange(new int[]{1, 2, 3}, 4); // [-1, -1]

        for (int re : res1) {
            System.out.print(re + " ");
        }
        System.out.println();
        for (int re : res2) {
            System.out.print(re + " ");
        }
        System.out.println();
        for (int re : res3) {
            System.out.print(re + " ");
        }
        System.out.println();
    }
}
