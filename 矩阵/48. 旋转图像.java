// 后面的被n-1再减去，并且移到前面
// 前面的变成后面


class Solution {

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 一圈一圈的旋转，一共需要 n/2 圈
        for (int i = 0; i < n / 2; i++) {
            // 每次从第 i 行第 j 列为起点开始旋转
            // 注意循环不变量原则：我是按照左闭右开的形式进行旋转，所以是 n - 1 - i
            for (int j = i; j < n - i - 1; j++) {
                // 保存上边
                int temp = matrix[i][j];

                // 左边赋值给上边
                matrix[i][j] = matrix[ n - 1 -j][i];

                // 下边赋值给左边
                // 上面等式的右边就是下面等式的左边，
                // 意思就是接着上面等式继续原地修改，因为这个值已经被上面等式保存了
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];

                // 右边赋值给下边
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];

                // 上边赋值给右边
                matrix[j][n - 1 - i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Solution solution = new Solution();
        solution.rotate(matrix);
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
