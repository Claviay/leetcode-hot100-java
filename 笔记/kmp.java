import java.util.ArrayList;
import java.util.List;

public class Solution {

    // 构建前缀函数（LPS 数组）
    private static int[] buildLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int length = 0; // 长度为当前最长前缀
        int i = 1;

        lps[0] = 0; // 第一个字符的前缀函数值总是 0

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;

                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;

                    i++;
                }
            }
        }

        return lps;
    }

    // KMP 算法主函数
    public static List<Integer> kmpSearch(String text, String pattern) {
        List<Integer> result = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();

        int[] lps = buildLPS(pattern);

        int i = 0; // 文本索引
        int j = 0; // 模式索引

        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) { // 索引到达末端
                result.add(i - j); // 匹配成功，记录匹配起始位置
                j = lps[j - 1];
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return result;
    }

    // 测试示例
    public static void main(String[] args) {
        String text = "ababcababcabc";
        String pattern = "abc";

        List<Integer> matches = kmpSearch(text, pattern);

        // Pattern found at indices: [2, 7, 10]
        System.out.println("Pattern found at indices: " + matches);
    }
}
