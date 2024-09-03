import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>(); // 用于存储所有合法的括号组合
        char[] path = new char[2 * n]; // 当前路径，存储正在构建的括号组合
        dfs(ans, path, 0, 0, 0, n); // 开始递归
        return ans;
    }

    private void dfs(List<String> ans, char[] path, int i, int left, int right, int n) {
        // 如果当前右括号多于左括号，不合法，直接返回
        if (left < right) return;

        // 如果构建的组合长度达到了2*n，并且左右括号数相等，表示构建完成
        if (left + right == n * 2) {
            if (left == right) {

                // new String(char[] value) 构造器：
                //
                //这个构造器可以将一个 char[] 数组转换为 String 对象。
                ans.add(new String(path)); // 将合法组合加入结果列表
            }
            return;
        }

        // 选择添加一个左括号
        if (left < n) { // 只有在左括号还没达到 n 个时，才可以添加左括号
            path[i] = '(';
            dfs(ans, path, i + 1, left + 1, right, n);
        }

        // 选择添加一个右括号
        if (right < left) { // 只有在右括号数量少于左括号数量时，才可以添加右括号
            path[i] = ')';
            dfs(ans, path, i + 1, left, right + 1, n);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> result = solution.generateParenthesis(3);
        System.out.println(result);
    }
}
