class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i = 0; i < nums.length; i++){
            // 如果当前数字是负数，交换 imax 和 imin
            if(nums[i] < 0){ 
              int tmp = imax;
              imax = imin;
              imin = tmp;
            }
            // 更新当前的最大乘积 imax
            imax = Math.max(imax * nums[i], nums[i]);
            // 更新当前的最小乘积 imin
            imin = Math.min(imin * nums[i], nums[i]);
            
            // 更新全局最大乘积 max
            max = Math.max(max, imax);
        }
        return max;
    }
}
