import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // key是数字大小，value是坐标
        HashMap<Integer, Integer> map = new HashMap<>();

        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                res[0] = map.get(complement);
                res[1] = i;
                return res;
            }
            // 记录在案
            map.put(nums[i], i);
        }
        
        return res;
    }
}
