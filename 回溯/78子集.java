import java.util.*;
/*
O(n * 2^n)
*/
class Solution {
    // 存储所有生成的子集
    private List<List<Integer>> ans = new ArrayList<>();
    
    // 存储当前正在构建的子集
    private List<Integer> path = new ArrayList<>();
    
    // 输入数组
    private int[] nums;

    // 主方法：初始化 nums，调用 DFS 函数，并返回所有子集
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums; // 记录输入数组
        dfs(0); // 从索引 0 开始深度优先搜索
        return ans; // 返回所有生成的子集
    }

    // 深度优先搜索函数
    public void dfs(int index) {
        // 将当前的子集 path 加入到结果集 ans 中
        ans.add(new ArrayList<>(path));
        
        // 从当前索引开始，遍历所有可能的子集
        for (int i = index; i < nums.length; i++) {
            // 将当前元素添加到子集 path 中
            path.add(nums[i]);
            
            // 递归调用，处理下一个元素，注意索引为 i + 1，以避免重复
            dfs(i + 1);
            
            // 移除最后一个元素，以便尝试其他子集
            path.remove(path.size() - 1);
        }
    }
}
