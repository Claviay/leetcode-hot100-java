// 两个从最左边的指针开始
// 正常来说i不断向右
// 只有nums[i]!=0的情况下j才能向右
class Solution {
    public void moveZeroes(int[] nums) {
        if(nums==null) {
            return;
        }

        //两个指针i和j（两个指针都从左边开始）
        int j = 0;

        for(int i=0;i<nums.length;i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if(nums[i]!=0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }

        }

    }

}	
