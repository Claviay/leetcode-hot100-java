import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> alphabetIndex = new HashMap<>();
        int res = 0; // 最长子串的长度
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // 如果当前字符已存在，并且存在的位置在窗口左侧右边
            if (alphabetIndex.containsKey(currentChar) && alphabetIndex.get(currentChar) >= left) {
                left = alphabetIndex.get(currentChar) + 1;
            }

            // 更新或插入当前字符的位置
            alphabetIndex.put(currentChar, i);

            // 更新最长子串长度
            res = Math.max(res, i - left + 1);
        }

        return res;
    }
}
