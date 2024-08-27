class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;

        int left = 0;
        int right = matrix.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            
            // mid小于等于target
            // 并且，mid到达数组末尾 or [mid + 1]大于target
            if (matrix[mid][0] <= target && (mid == matrix.length - 1 || matrix[mid + 1][0] > target)) {
                left = mid;
                break;
            } else if (matrix[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }


        

        int closeTarget = searchInsert(matrix[left], target);
        if (closeTarget == -1) {
            return false;
        }
        return matrix[left][closeTarget] == target;
    }


    // 二分查找 一维数组
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // 如果left超出索引，返回-1
        // 或者只有近似值而没有目标值，返回-1
        // 正常返回目标索引
        return (left < nums.length && nums[left] == target) ? left : -1;
    }

    public static void main(String[] args) {
        int[][] m1 = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][] m2 = {{1}};
        int[][] m3 = {{1, 1}};
        int[][] m4 = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(new Solution().searchMatrix(m1,3)); // true
        System.out.println(new Solution().searchMatrix(m2,2)); // false
        System.out.println(new Solution().searchMatrix(m3,2)); // false
        System.out.println(new Solution().searchMatrix(m4,13)); // false
    }
}
