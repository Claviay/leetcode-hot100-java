import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static int maxSubArray(int[] nums) {
        // 下面是数组全是负数的情况
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            Arrays.sort(nums);
            return nums[nums.length - 1];
        }

        // 现在是含有非负数的情况
        // result是所有res里最大的
        int result = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {

            res += nums[i];
            result = Math.max(result, res);
            if (res < 0) {
                res = 0;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
