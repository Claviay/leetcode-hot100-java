import java.util.*;




/*
多维护一个min数组，在每一个最远的位置都有一个对应的min最小值
 */

class MinStack {
    public final int MAX = 8001;  // 栈的最大容量
    public int[] data, min;  // data存储栈元素，min存储每个元素对应的最小值
    int size;  // 当前栈中的元素数量

    public MinStack() {
        data = new int[MAX];  // 初始化栈数组
        min = new int[MAX];  // 初始化最小值数组
        size = 0;  // 初始时栈为空
    }

    public void push(int val) {
        data[size] = val;  // 将元素压入栈
        if (size == 0 || val <= min[size - 1]) {
            min[size] = val;  // 如果这是第一个元素或val小于等于当前最小值，更新最小值
        } else {
            min[size] = min[size - 1];  // 否则，保持最小值不变
        }
        size++;  // 栈大小加一
    }

    public void pop() {
        size--;  // 弹出栈顶元素，减少栈大小
    }

    public int top() {
        return data[size - 1];  // 返回栈顶元素
    }

    public int getMin() {
        return min[size - 1];  // 返回当前栈的最小值
    }
}

/*
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
