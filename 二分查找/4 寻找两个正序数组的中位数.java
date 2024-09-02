// O(Log(Min(M,N)))


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 获取两个数组的长度
        int nums1Len = nums1.length;
        int nums2Len = nums2.length;

        // 确保第一个数组（nums1）长度不大于第二个数组（nums2）
        // 这样可以保证nums1是较短的数组，从而减少需要遍历的次数
        if (nums1Len > nums2Len) {
            return findMedianSortedArrays(nums2, nums1);
        }

        // 定义二分查找的边界，low和high分别是nums1的搜索范围
        int low = 0, high = nums1Len;

        // 使用二分查找法来寻找合适的划分点
        while (low <= high) {
            // 计算nums1的中间分割点（patitionOfNums1）
            int patitionOfNums1 = (high + low) / 2;
            
            // 根据nums1的分割点，推导出nums2的分割点（patitionOfNums2）
            // 中位数的分割应该将nums1和nums2整体分成两部分，并保证两部分的长度相等或相差1
            int patitionOfNums2 = (nums1Len + nums2Len + 1) / 2 - patitionOfNums1;

            // 定义变量来存储nums1分割后的最大左边值和最小右边值
            int leftMaxOfNums1;
            int rightMinOfNums1;

            // 定义变量来存储nums2分割后的最大左边值和最小右边值
            int leftMaxOfNums2;
            int rightMinOfNums2;

            // 如果patitionOfNums1已经分割到nums1的最右边，说明右边没有数，
            // 此时将rightMinOfNums1设为Integer.MAX_VALUE（无限大）
            if (patitionOfNums1 == nums1Len) {
                rightMinOfNums1 = Integer.MAX_VALUE;
            } else {
                // 否则，rightMinOfNums1就是patitionOfNums1对应的值
                rightMinOfNums1 = nums1[patitionOfNums1];
            }

            // 如果patitionOfNums1已经分割到nums1的最左边，说明左边没有数，
            // 此时将leftMaxOfNums1设为Integer.MIN_VALUE（无限小）
            if (patitionOfNums1 == 0) {
                leftMaxOfNums1 = Integer.MIN_VALUE;
            } else {
                // 否则，leftMaxOfNums1就是patitionOfNums1左边的值
                leftMaxOfNums1 = nums1[patitionOfNums1 - 1];
            }

            // 对nums2进行类似的操作：
            // 如果patitionOfNums2在nums2的最右边，则rightMinOfNums2设为Integer.MAX_VALUE
            if (patitionOfNums2 == nums2Len) {
                rightMinOfNums2 = Integer.MAX_VALUE;
            } else {
                rightMinOfNums2 = nums2[patitionOfNums2];
            }

            // 如果patitionOfNums2在nums2的最左边，则leftMaxOfNums2设为Integer.MIN_VALUE
            if (patitionOfNums2 == 0) {
                leftMaxOfNums2 = Integer.MIN_VALUE;
            } else {
                leftMaxOfNums2 = nums2[patitionOfNums2 - 1];
            }

            // 核心条件：检查分割是否合理
            // 如果nums1的左边最大值小于等于nums2的右边最小值，且nums2的左边最大值小于等于nums1的右边最小值，
            // 那么找到合适的分割点，此时可以计算中位数
            if (leftMaxOfNums1 <= rightMinOfNums2 && leftMaxOfNums2 <= rightMinOfNums1) {
                // 如果两个数组的总长度为偶数，则中位数是左边最大值和右边最小值的平均值
                if ((nums1Len + nums2Len) % 2 == 0) {
                    return (double) ((Math.max(leftMaxOfNums1, leftMaxOfNums2))
                            + Math.min(rightMinOfNums2, rightMinOfNums1)) / 2.0;
                } else {
                    // 如果总长度为奇数，则中位数是左边部分的最大值
                    return Math.max(leftMaxOfNums1, leftMaxOfNums2);
                }
            } 
            // 如果nums1的左边最大值大于nums2的右边最小值，说明nums1的分割点太靠右，需要左移
            else if (leftMaxOfNums1 > rightMinOfNums2) {
                // patition是基于low与high并且在两者之间的，右区间左移，那么分界点左移
                high = patitionOfNums1 - 1;
            } 
            // 否则说明nums1的分割点太靠左，需要右移
            else {
                // patition是基于low与high并且在两者之间的，左！区间右移，那么分界点右移
                low = patitionOfNums1 + 1;
            }
        }

        // 正常来说程序不会运行到这里，如果运行到这里说明输入数组不合法
        throw new IllegalArgumentException();
    }
}
