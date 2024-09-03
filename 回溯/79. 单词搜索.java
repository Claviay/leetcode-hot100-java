class Solution {
    public boolean exist(char[][] board, String word) {
        // 将目标单词转换为字符数组，方便逐个字符处理
        char[] words = word.toCharArray();

        // 遍历网格的每个位置作为潜在的起点
        for(int i = 0; i < board.length; i++) { // 遍历行
            for(int j = 0; j < board[0].length; j++) { // 遍历列
                // 如果从当前位置开始的DFS能够找到完整的单词，返回true
                if (dfs(board, words, i, j, 0)) return true;
            }
        }
        // 如果遍历了整个网格仍然没有找到匹配的路径，返回false
        return false;
    }

    // 深度优先搜索函数
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        // 检查当前索引是否越界，或当前网格字符与单词中的字符不匹配
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k])
            return false; // 返回false，表示从这条路径无法找到匹配

        // 如果已经匹配到了单词的最后一个字符，说明找到了匹配路径
        if (k == word.length - 1)
            return true; // 返回true






        // 为了防止重复访问，将当前格子标记为已访问。使用 '\0' 是因为 '\0' 是一个特殊的不可见字符。
        board[i][j] = '\0';

        // 递归调用DFS函数，检查四个方向（上、下、左、右）
        boolean res = dfs(board, word, i + 1, j, k + 1) || // 向下
                dfs(board, word, i - 1, j, k + 1) || // 向上
                dfs(board, word, i, j + 1, k + 1) || // 向右
                dfs(board, word, i , j - 1, k + 1);  // 向左

        //------------------------------------------
        // 回溯：恢复当前格子的原始值，以便后续搜索使用
        board[i][j] = word[k];
        //-----------------------------------------




        
        // 返回搜索结果。如果任意方向的递归结果为true，res就为true。
        return res;
    }
}
