class Solution {
    public static List<Integer> spiralOrder(int[][] matrix) {
    LinkedList<Integer> result = new LinkedList<>(); // 创建一个链表用于存储结果
    if (matrix == null || matrix.length == 0) return result; // 如果矩阵为空或者行数为0，直接返回空链表

    int left = 0; // 定义左边界
    int right = matrix[0].length - 1; // 定义右边界
    int top = 0; // 定义上边界
    int bottom = matrix.length - 1; // 定义下边界
    int numEle = matrix.length * matrix[0].length; // 计算矩阵中元素的总数

    // 使用循环依次遍历螺旋路径，直到所有元素都被访问过
    while (numEle >= 1) {
        // 从左到右遍历上边界
        for (int i = left; i <= right && numEle >= 1; i++) {
            result.add(matrix[top][i]); // 将元素添加到结果链表
            numEle--; // 减少剩余元素数量
        }
        top++; // 上边界向下移动

        // 从上到下遍历右边界
        for (int i = top; i <= bottom && numEle >= 1; i++) {
            result.add(matrix[i][right]);
            numEle--;
        }
        right--; // 右边界向左移动

        // 从右到左遍历下边界
        for (int i = right; i >= left && numEle >= 1; i--) {
            result.add(matrix[bottom][i]);
            numEle--;
        }
        bottom--; // 下边界向上移动

        // 从下到上遍历左边界
        for (int i = bottom; i >= top && numEle >= 1; i--) {
            result.add(matrix[i][left]);
            numEle--;
        }
        left++; // 左边界向右移动
    }

    return result; // 返回存储结果的链表
    }

}
