class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 计算字典中最长单词的长度，用于优化后续的子串检查过程
        int maxLen = 0;
        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }

        // 将列表形式的字典转换为HashSet，加快查找速度
        Set<String> words = new HashSet<>(wordDict);

        // 获取字符串s的长度
        int n = s.length();
        
        // 创建一个布尔数组f，长度为n+1。f[i]表示s的前i个字符是否可以被拆分成字典中的单词
        boolean[] f = new boolean[n + 1];
        
        // 初始化f[0]为true，因为空字符串默认是可以被“拆分”的
        f[0] = true;

        // 遍历字符串s的每个位置i（从1到n）
        for (int i = 1; i <= n; i++) {
            // 从位置i-1开始向前遍历，直到遇到可能的最大长度或者到达字符串的开头
            for (int j = i - 1; j >= Math.max(i - maxLen, 0); j--) {
                // 如果f[j]为true且从j到i的子串存在于字典中，则设置f[i]为true，并跳出循环
                if (f[j] && words.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }

        // 返回f[n]，即整个字符串s是否可以被拆分成字典中的单词
        return f[n];
    }
}
