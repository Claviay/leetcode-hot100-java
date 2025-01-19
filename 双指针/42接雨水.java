import java.util.*;
public class Solution {
    public static int trap(int[] height) {
        int[] leftMax = new int[20001];
        int[] rightMax = new int[20001];

        int len = height.length;
        int leftMaxElement = height[0];
        leftMax[0] = leftMaxElement;
        int rightMaxElement = height[len - 1];
        rightMax[len - 1] = rightMaxElement;

        for (int i = 1; i < len; i++) {
            leftMaxElement = Math.max(leftMaxElement, height[i]);
            leftMax[i] = leftMaxElement;
        }

        for (int i = len - 2; i >= 0; i--) {
            rightMaxElement = Math.max(rightMaxElement, height[i]);
            rightMax[i] = rightMaxElement;
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return res;





    }
}
