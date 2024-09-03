import java.util.*;

class Solution {
    // 方向
    public static final int[][] DIRECTIONS = {{0,1},{0,-1},{1,0},{-1,0}};

    public int orangesRotting(int[][] grid) {
        List<int[]> oldOranges = new ArrayList<>();
        int fresh = 0;

        // 遍历网格，找到所有新鲜和腐烂的橘子
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    oldOranges.add(new int[]{i, j});
                }
            }
        }

        int ans = 0;
        // BFS 扩展腐烂过程
        while (!oldOranges.isEmpty()) {
            List<int[]> tempOranges = oldOranges;
            oldOranges = new ArrayList<>();

            for (int[] orange : tempOranges) {
                for (int[] direction : DIRECTIONS) {
                    int x = orange[0] + direction[0];
                    int y = orange[1] + direction[1];

                    // 如果相邻的橘子是新鲜的
                    if (0 <= x && x < grid.length && 0 <= y && y < grid[0].length && grid[x][y] == 1) {
                        // 被传播成坏橘子
                        grid[x][y] = 2;
                        oldOranges.add(new int[]{x, y});
                        fresh--;
                    }
                }
            }
            // 只有当有橘子被腐烂时才增加时间
            if (!oldOranges.isEmpty()) {
                ans++;
            }
        }

        // 如果没有剩余的新鲜橘子，返回时间，否则返回-1
        return (fresh == 0) ? ans : -1;
    }
}
