/*
2.「非首行首列」的位置

    将置零信息存储到原矩阵
    根据置零信息，置零「非首行首列」的位置
*/
class Solution {
    public void setZeroes(int[][] matrix) {
        // 获取矩阵的行数和列数
        int row = matrix.length;
        int col = matrix[0].length;

        // 用来标记第一行和第一列是否需要被置零
        boolean row0_flag = false;
        boolean col0_flag = false;

        // 检查第一行是否有零元素，如果有，则将row0_flag设置为true
        for (int j = 0; j < col; j++) {
            if (matrix[0][j] == 0) {
                row0_flag = true;
                break;
            }
        }

        // 检查第一列是否有零元素，如果有，则将col0_flag设置为true
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                col0_flag = true;
                break;
            }
        }

        // 遍历矩阵，将零元素所在的行和列的第一个元素设为零，作为标志位
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        // 根据标志位，将其他元素置零
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 如果第一行需要被置零，将第一行的所有元素置零
        if (row0_flag) {
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }

        // 如果第一列需要被置零，将第一列的所有元素置零
        if (col0_flag) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        } 
    }
}
