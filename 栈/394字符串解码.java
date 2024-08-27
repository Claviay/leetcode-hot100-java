import java.util.Stack;
/*


1. 核心思想
这个算法使用 双栈 的策略来处理字符串解码问题：

数字栈 numStack：用于存储数字，即表示某个子字符串需要重复的次数。

字符串栈 stringStack：用于存储在每一层括号之前的字符串，这样在遇到 ] 时，
可以将栈顶的字符串与解码后的字符串进行合并。


同时还有currentNum、currentString
 */
class Solution {
    public String decodeString(String s) {
        // 初始化两个栈，一个用于存储数字，一个用于存储字符串
        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        int num = 0; // 当前处理的数字，用于解析多位数
        String curString = ""; // 当前处理的字符串

        // 遍历整个字符串
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); // 当前字符

            if(Character.isDigit(c)){
                // 如果是数字，更新当前的num值，处理可能的多位数
                num = num * 10 + c - '0';
            } else if (c == '[') {
                // 如果遇到左括号，压入当前的num和字符串到栈中，重置num和curString
                numStack.push(num);
                stringStack.push(curString);
                num = 0;
                curString = "";
            } else if (c == ']') {
                // 如果遇到右括号，开始解码
                int loopTimes = numStack.pop(); // 获取栈顶数字，表示重复次数
                StringBuilder temp = new StringBuilder(stringStack.pop()); // 获取栈顶字符串，并开始构建新的字符串
                for (int j = 0; j < loopTimes; j++) {
                    temp.append(curString); // 将当前的字符串重复多次并拼接到temp中
                }
                curString = temp.toString(); // 更新当前的字符串为拼接后的结果
            } else {
                // 如果是字母，直接添加到当前字符串中
                curString += c;
            }
        }
        return curString; // 返回最终解码后的字符串
    }

    public static void main(String[] args) {
    }
}
