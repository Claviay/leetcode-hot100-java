class Solution {
    public int longestValidParentheses(String s) {
        // 初始化一个栈，用来存储下标
        Stack<Integer> stack = new Stack<>();
        int maxAns = 0; // 记录最长有效括号的长度
        stack.push(-1); // 栈初始时压入 -1，作为起始位置的标记
        
        // 遍历字符串中的每一个字符
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // 如果当前字符是左括号，将它的下标压入栈中
                stack.push(i);
            } else { // 当前字符是右括号
                // 弹出栈顶元素，尝试匹配一个左括号
                stack.pop();
                
                // 如果栈为空，说明当前的右括号没有匹配的左括号
                if (stack.isEmpty()) {
                    // 将当前右括号的下标压入栈中，作为新的起始位置标记
                    stack.push(i);
                } else {
                    // 如果栈不为空，计算当前有效括号长度
                    // 当前右括号的位置 i 减去栈顶元素的下标（栈顶元素是上一个未匹配的右括号或初始位置）
                    maxAns = Math.max(maxAns, i - stack.peek());
                }
            }
        }
        return maxAns; // 返回最长有效括号的长度
    }
}
