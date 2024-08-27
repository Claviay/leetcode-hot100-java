import java.util.Deque;
import java.util.ArrayDeque;
/*
O(n)

左边界 left[]：对于每个柱子，left[i] 表示在 i 位置左边第一个高度小于 heights[i] 的柱子位置
如果没有这样的柱子，则 left[i] 为 -1。

右边界 right[]：对于每个柱子，right[i] 表示在 i 位置右边第一个高度小于 heights[i] 的柱子位置
如果没有这样的柱子，则 right[i] 为 n。
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n]; // 存储每个柱子的左边界
        Deque<Integer> st = new ArrayDeque<>(); // 单调栈用于计算左边界

        // 计算每个柱子的左边界
        for (int i = 0; i < n; i++) {
            int x = heights[i];
            // 如果栈顶柱子的高度大于等于当前柱子的高度，弹出栈顶
            while (!st.isEmpty() && x <= heights[st.peek()]) {
                st.pop();
            }
            // 更新左边界
            left[i] = st.isEmpty() ? -1 : st.peek();
            // 当前柱子的位置入栈
            st.push(i);
        }



        int[] right = new int[n]; // 存储每个柱子的右边界
        st.clear(); // 清空栈用于计算右边界

        // 计算每个柱子的右边界
        for (int i = n - 1; i >= 0; i--) {
            int x = heights[i];
            // 如果栈顶柱子的高度大于等于当前柱子的高度，弹出栈顶
            while (!st.isEmpty() && x <= heights[st.peek()]) {
                st.pop();
            }
            // 更新右边界
            right[i] = st.isEmpty() ? n : st.peek();
            // 当前柱子的位置入栈
            st.push(i);
        }




        int ans = 0;
        // 计算每个柱子为高度的最大矩形面积
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, heights[i] * (right[i] - left[i] - 1));
        }
        return ans; // 返回最大矩形面积
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(solution.largestRectangleArea(heights)); // 输出 10
    }
}
