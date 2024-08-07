import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        // 异常0
        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        for (Integer num: nums) {
            set.add(num); //消去重复元素 HashSet不会加上重复元素
        }

        int len = 1, max_len = 1;
        for (Integer num: set) {
            if (!set.contains(num - 1)) { // 这里的节省时间很重要
                //如果是一个起始点，则开始统计（节省时间）
                len = 1;
                while(set.contains(++num)) {
                    len++;
                    max_len = Math.max(max_len, len);
                }
            }
        }
        return max_len;
    }
}
