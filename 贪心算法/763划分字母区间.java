class Solution {
    public List<Integer> partitionLabels(String S) {
        char[] s = S.toCharArray(); // 将字符串转换为字符数组
        int n = s.length; // 获取字符串的长度
        int[] last = new int[26]; // 用于记录每个字母最后出现的位置
        
        // 第一遍遍历：记录每个字母在字符串中最后出现的位置
        for (int i = 0; i < n; i++) {
            last[s[i] - 'a'] = i; // 将字母 s[i] 在字符串中最后出现的位置记录在数组 last 中
        }

        List<Integer> ans = new ArrayList<>(); // 用于存储结果的列表
        int start = 0, end = 0; // 初始化区间的起始位置 start 和结束位置 end
        
        // 第二遍遍历：根据字符的最后出现位置划分片段
        for (int i = 0; i < n; i++) {
            end = Math.max(end, last[s[i] - 'a']); // 更新当前区间右端点的最大值
            if (end == i) { // 如果当前遍历到的位置正好是区间的结束位置
                ans.add(end - start + 1); // 将当前区间的长度添加到结果列表中
                start = i + 1; // 更新下一个区间的起始位置
            }
        }
        return ans; // 返回最终的片段长度列表
    }
}
