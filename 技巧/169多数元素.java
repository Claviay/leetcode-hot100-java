/*
摩尔投票法
常量级别的空间容量
*/
import java.util.*;
class Solution {
    public int majorityElement(int[] nums) {
        int res = nums[0]; // 确定候选人
        int count = 1;     // 初始化投票数
        for (int i = 1; i < nums.length; i++) {
            if (res == nums[i]) {
                count++;
            }
            else {
                count -= 1;
                if (count == 0) {  // 当投票数变为0，更换候选人
                    res = nums[i];
                    count = 1;    // 初始化投票数
                }
            }
        }

        return res;
    }
}
