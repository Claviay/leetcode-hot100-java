// i是最左指针 j是最右指针   不断拿掉两边更多的板子并前进1个
class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;


        // 这个逻辑成立的原因是，比如，看这个两个：如果左边的一个板子a，以及右边板子b
        // 如果a比b高，那么宽和高都强的情况下，显然a不应该右移
        
        // 只有较小的那个先移动，才有可能得到更大的结果
        while(i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]):
                    Math.max(res, (j - i) * height[j--]);
        }

        return res;
    }
}
