import java.util.*;
/*
任何数 异或 0 = 这个数本身
任何数 异或 这个数本身 = 0

所以初始值应该设置为0
*/
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;

        for (int num : nums) {
            res ^= num;
        }

        return res;
    }
}
