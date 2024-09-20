import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public void rotate1(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    public void rotate(int[] nums, int k) {
        // 将nums转换为List<Integer>
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());

        // 使用Collections.rotate旋转列表
        Collections.rotate(list, k);

        // 将List<Integer>转换回int[]并赋值给nums
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
    }
}
