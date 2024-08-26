
import java.util.*;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k); // 调用快速选择算法查找第k大的元素
    }

    private int quickSelect(int[] nums, int k) {
        // 基于快排的快速选择

        Random rand = new Random();
        int pivot = nums[rand.nextInt(nums.length)]; // 随机选择一个基准元素 pivot

        // 将大于、等于、小于 pivot 的元素分别放入三个列表
        List<Integer> big = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> small = new ArrayList<>();

        for (int num : nums) {
            if (num < pivot)
                small.add(num);  // 小于 pivot 的元素放入 small
            else if (num == pivot)
                equal.add(num);  // 等于 pivot 的元素放入 equal
            else
                big.add(num);    // 大于 pivot 的元素放入 big
        }

        // 第k大元素在 big 中, 递归查找
        if (k <= big.size()) {
            return quickSelect(big.stream().mapToInt(Integer::intValue).toArray(), k); // 如果第k大元素在big中，继续在big中查找
        }

        // 第k大元素在 small 中, 递归查找
        if (k > big.size() + equal.size()) {
            return quickSelect(small.stream().mapToInt(Integer::intValue).toArray(), k - (big.size() + equal.size())); // 如果在small中，调整k值并在small中查找
        }


        // 如果上面两个if都没有进入，显然就是第k大元素在 equal 中
        // 第k大元素在 equal 中, 返回基准元素 pivot
        return pivot; // 第k大元素在 equal 中，返回 pivot
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int result = solution.findKthLargest(nums, k);

        // 输出：The 2th largest element is 5
        System.out.println("The " + k + "th largest element is " + result);
    }
}
