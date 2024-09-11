class Solution {
public int[] productExceptSelf(int[] nums) {
    int len = nums.length;
    if (len == 0) return new int[0];  // 如果输入数组为空，则返回空数组

    int[] ans = new int[len];
    ans[0] = 1;  // 初始化第一个位置为 1

    // 计算每个位置的左侧乘积
    for (int i = 1; i < len; i++) {
        ans[i] = ans[i - 1] * nums[i - 1];
    }

    // 计算每个位置的右侧乘积，并与之前的左侧乘积相乘
    int tmp = 1;
    for (int i = len - 2; i >= 0; i--) {
        tmp *= nums[i + 1];  // 更新右侧乘积
        ans[i] *= tmp;  // 更新结果数组中的值
    }

    return ans;
}

}
