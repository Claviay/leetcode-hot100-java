import java.util.*;
/*
2. 时间复杂度
DFS 和 BFS 的时间复杂度都是 O(M * N)，其中 M 和 N 分别是网格的行数和列数。
每个节点（'1' 或 '0'）在整个遍历过程中会被访问一次。


3. 空间复杂度
DFS 的空间复杂度主要受递归深度的影响，最坏情况下（完全被水包围的一个巨大的岛屿），
递归深度可能达到 O(M * N)。这在递归栈空间有限的环境中可能会导致栈溢出。

BFS 的空间复杂度由队列的最大长度决定，最坏情况下，队列中需要存储整个边界上的节点，
空间复杂度为 O(min(M, N))。一般来说，BFS 在空间利用上会比DFS更优。


4. 实现的简洁性
DFS 的实现通常较为简洁，利用递归的自然栈结构，代码短小而清晰。
BFS 需要显式维护一个队列，代码稍显冗长，但在避免深度过大的情况下更为安全。

 */

// dfs深度
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;

        // 这里改成0很重要，不然会重复计数
        grid[i][j] = '0';

        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }







    // bfs
    public int numIslandsBFS(char[][] grid) {
        int count = 0; // 用于计数岛屿的数量
        for (int i = 0; i < grid.length; i++) { // 遍历网格的每一行
            for (int j = 0; j < grid[0].length; j++) { // 遍历网格的每一列
                if (grid[i][j] == '1') { // 如果当前格子是陆地（'1'）
                    bfs(grid, i, j); // 执行 BFS 来遍历整个岛屿
                    count++; // 每执行一次 BFS，就计数一次，表示找到了一个新的岛屿
                }
            }
        }
        return count; // 返回岛屿的数量
    }

    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>(); // 创建一个队列来进行广度优先搜索
        queue.add(new int[]{i, j}); // 将起始位置（岛屿的某一部分）加入队列

        while (!queue.isEmpty()) { // 当队列不为空时，继续搜索
            int[] pos = queue.poll(); // 从队列中取出当前处理的位置
            int x = pos[0], y = pos[1]; // 当前格子的行列坐标

            // 检查当前格子是否在网格边界内并且是陆地
            if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == '1') {
                grid[x][y] = '0'; // 标记为水，表示这个格子已经被访问过

                // 将当前格子四周的上下左右相邻的格子加入队列，准备进一步检查
                queue.add(new int[]{x + 1, y}); // 下方格子
                queue.add(new int[]{x - 1, y}); // 上方格子
                queue.add(new int[]{x, y + 1}); // 右边格子
                queue.add(new int[]{x, y - 1}); // 左边格子
            }
        }
    }
}


