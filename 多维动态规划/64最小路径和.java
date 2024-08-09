/*
只能向右或者向下

和第62题最小路径差不多，都是比较简单清晰的动态规划，
因为方向只能向右和向下，所以主要需要注意的地方只有边界判断
 */
class Solution {
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0 && j >= 1) { 
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                }
                else if (j == 0 && i >= 1) {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                }
                else {
                    grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }
}
