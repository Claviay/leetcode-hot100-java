import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] onPath = new boolean[nums.length];
        
        dfs(nums, ans, path, onPath);
        return ans;
    }

    public void dfs(int[] nums, List<List<Integer>> ans, List<Integer> path, boolean[] onPath) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!onPath[i]) {
                // 添加当前元素到路径
                path.add(nums[i]);
                // 标记当前元素为已使用
                onPath[i] = true;

                // 递归调用
                dfs(nums, ans, path, onPath);
                
                // 回溯
                // path.remove(index)：这个方法用于从列表中移除指定索引处的元素。
                // 这里的 index 是 path.size() - 1，即最后一个元素的位置。
                path.remove(path.size() - 1);
                onPath[i] = false;
            }
        }
    }
}
