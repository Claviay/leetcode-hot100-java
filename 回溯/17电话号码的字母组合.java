import java.util.*;
/*
O(4^n)
*/
class Solution {

    // 每个数字对应的字母映射
    private static final String[] MAPPING = new String[]
            {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    // 存储所有生成的字母组合
    private final List<String> ans = new ArrayList<>();

    // 输入数字的字符数组
    private char[] digits;

    // 存储当前生成的字母组合
    private char[] path;

    // 主方法，接受一个数字字符串并返回所有字母组合
    public List<String> letterCombinations(String digits) {
        int n = digits.length();

        // 如果输入为空，直接返回空列表
        if (n == 0) {
            return List.of();
        }

        // 将输入字符串转换为字符数组
        this.digits = digits.toCharArray();
        // 初始化 path，长度固定为 n
        path = new char[n];

        // 开始深度优先搜索
        dfs(0);

        // 返回所有生成的字母组合
        return ans;
    }

    // 深度优先搜索函数
    private void dfs(int i) {
        // 如果已处理完所有数字，当前 path 就是一个有效的字母组合
        if (i == digits.length) {
            ans.add(new String(path));
            return;
        }

        // 获取当前数字对应的字母组合
        for (char c : MAPPING[digits[i] - '0'].toCharArray()) {
            // 选择当前字母并递归处理下一个数字
            path[i] = c;  // 注意这里可以直接覆盖
            dfs(i + 1);
        }
    }
}
