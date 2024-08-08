/*
思路是慢慢把雨水填平
哪边小就走走哪边

*/

public class Solution {
    public static int trap(int[] height) {
        int len = height.length;
        if (len <= 2) {
            return 0;
        }
        
        int result = 0;
        int left_max = height[0];
        int right_max = height[len - 1];
        int i = 1, j = len - 2;

        while (i <= j) {
            if (left_max < right_max) {
                if (height[i] < left_max) {
                    result += left_max - height[i];
                }
                i++;
                left_max = Math.max(height[i-1], left_max);  // 对比当前的高度 以及 left_max
            } else {
                if (height[j] < right_max) {
                    result += right_max - height[j];
                }
                j--;
                right_max = Math.max(height[j+1], right_max);   // 对比当前的高度 以及 right_max
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] h = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] x = {4,2,0,3,2,5};

        System.out.println(trap(h)); // 输出 6
        System.out.println(trap(x)); // 输出 9
    }
}
