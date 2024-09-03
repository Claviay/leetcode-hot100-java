import java.util.*;
/*
组合排列和  全排列  类似



特殊的：
剪枝一: 如果当前子集和超过目标值 target，则结束当前循环。由于数组已经排序，后续元素必定更大，不可能达到目标，因此直接跳出循环。
剪枝二: 从 start 开始遍历，可以避免生成重复的子集。

 */
class Solution {
    void backtrack(List<Integer> state, int target, int[] choices, int start, List<List<Integer>> res) {
        // 子集和等于 target 时，记录解
        if (target == 0) {
            res.add(new ArrayList<>(state));
            return;
        }
        // 遍历所有选择
        // 剪枝二：从 start 开始遍历，避免生成重复子集
        for (int i = start; i < choices.length; i++) {
            // 剪枝一：若子集和超过 target ，则直接结束循环
            // 这是因为数组已排序，后边元素更大，子集和一定超过 target
            if (target - choices[i] < 0) {
                break;
            }






            // 尝试：做出选择，更新 target, start
            state.add(choices[i]);
            // 进行下一轮选择
            backtrack(state, target - choices[i], choices, i, res);

            // 去掉末尾的元素
            // 回退：撤销选择，恢复到之前的状态
            state.remove(state.size() - 1);





        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> state = new ArrayList<>(); // 状态（子集）
        Arrays.sort(candidates); // 对 candidates 进行排序
        int start = 0; // 遍历起始点
        List<List<Integer>> res = new ArrayList<>(); // 结果列表（子集列表）
        backtrack(state, target, candidates, start, res);
        return res;
    }
}
