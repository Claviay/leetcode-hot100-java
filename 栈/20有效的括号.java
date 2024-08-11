import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s == null || s.isEmpty()) return true;
        if (s.length()%2 != 0) return false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // 左括号，放进去
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            }
            
            // 右括号，则从stack中取出一个，看看是否对应
            else if (c == '}' || c == ']' || c == ')') {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (top == '(' && c != ')') {
                    return false;
                }
                else if (top == '{' && c != '}') {
                    return false;
                }
                else if (top == '[' && c != ']') {
                    return false;
                }
            }
        }
        
        // 最后看看，是不是空的，如果一一对应，则stack应该是空的
        return stack.isEmpty();

    }
}
