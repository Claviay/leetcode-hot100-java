import java.util.Stack;
/*
弹出栈中所有小于等于当前温度的索引
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = temperatures.length - 1; i >= 0; i--) {
            // 弹出栈中所有小于等于当前温度的索引
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }

            // 如果栈不为空，则计算下一个更高温度的天数差距
            if (!stack.isEmpty()) {
                res[i] = stack.peek() - i;
            } else {
                res[i] = 0; // 栈为空表示后面没有更高的温度
            }

            // 将当前索引压入栈中
            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] temperatures = new int[]{73,74,75,71,69,72,76,73};
        int[] res = new Solution().dailyTemperatures(temperatures);
        for (int i = 0; i < temperatures.length; i++) {
            System.out.print(res[i] + " ");
        }

        // Output: 1 1 4 2 1 1 0 0
    }
}
