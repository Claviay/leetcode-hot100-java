import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
状态dp
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 使用 HashSet 来存储字典中的单词，查找速度更快
        Set<String> set = new HashSet<>(wordDict);

        int sLength = s.length();
        // 定义一个布尔数组 dp，用于记录从 0 到 i 的子串是否可以被拆分
        boolean[] dp = new boolean[sLength + 1];
        dp[0] = true; // 空字符串可以被拆分

        // 遍历字符串 s 的每个位置 i
        for (int i = 1; i <= sLength; i++) {
            // 遍历每个可能的前缀 j，检查从 j - 1 到 i - 1 的子串是否在字典中
            for (int j = 1;   j <= i && !dp[i]  ; j++) {
                String sub = s.substring(j - 1, i);
                
                if (set.contains(sub)) {
                    dp[i] = dp[j - 1]; // 如果找到合适的拆分点，则 dp[i] 为真
                }
            }
        }

        // 返回整个字符串 s 是否可以被拆分
        return dp[sLength];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String>  wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        wordDict.add("code");
        Solution solution = new Solution();
        System.out.println(solution.wordBreak(s, wordDict));
    }
}
