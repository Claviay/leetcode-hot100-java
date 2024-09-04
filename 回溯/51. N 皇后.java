import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<String>> res = new ArrayList<>();  // 存储所有解
    List<String> path = new ArrayList<>();  // 存储当前路径

    // index 是行， 对应的值是所在的列
    int[] chessboard;  // 存储每行皇后所在的列

    public List<List<String>> solveNQueens(int n) {
        chessboard = new int[n];  // 初始化棋盘
        Arrays.fill(chessboard, -1);  // 初始化为-1，表示还未放置皇后
        backTrack(0, n);  // 从第0行开始回溯
        return res;  // 返回所有可能的解
    }

    // 回溯方法：在第row行尝试放置皇后
    public void backTrack(int row, int n) {
        // 递归终止条件：如果已经放置了n个皇后
        if (row == n) {
            res.add(new ArrayList<>(path));  // 保存当前棋盘
            return;
        }

        // 尝试在当前行的每一列放置皇后
        for (int i = 0; i < n; i++) {
            if (!isValid(row, i)) continue;  // 检查当前列是否合法
            StringBuilder str = new StringBuilder();
            // 构建当前行的字符串表示
            for (int j = 0; j < n; j++) {
                if (j != i) str.append('.');  // 非皇后位置
                else str.append('Q');  // 皇后位置
            }

            path.add(str.toString());  // 保存当前行的棋盘状态
            chessboard[row] = i;  // 记录当前行皇后的位置
            backTrack(row + 1, n);  // 递归处理下一行
            path.remove(path.size() - 1);  // 回溯，移除当前行
            chessboard[row] = -1;  // 恢复棋盘状态
        }
    }


    // 检查(row, col)位置是否可以放置皇后
    private boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            // 检查同一列是否有皇后
            if (chessboard[i] == col) {
                return false;
            }

            // 检查主对角线是否有皇后
            // 对角线就是横轴、纵轴同时平移相同的距离
            if (chessboard[i] + i == col + row) {
                return false;
            }
            // 检查副对角线是否有皇后
            if (chessboard[i] - i == col - row) {
                return false;
            }
        }
        return true;  // 如果没有冲突，返回true
    }
}
