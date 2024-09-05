// Trie 字典树类
class Trie {
    Node root; // 根节点

    // 构造函数，初始化根节点
    public Trie() {
        root = new Node();
    }

    // 插入单词到字典树中
    public void insert(String word) {
        int n = word.length(); // 单词长度
        Node node = root; // 从根节点开始
        for (int i = 0; i < n; i++) {
            int id = word.charAt(i) - 'a'; // 计算当前字符的索引
            if (node.children[id] == null) {
                node.children[id] = new Node(); // 如果该节点不存在，创建新节点
            }
            node = node.children[id]; // 移动到下一个节点
        }
        node.isEnd = true; // 标记单词结束
    }

    // 查找字典树中是否存在指定单词
    public boolean search(String word) {
        Node node = startsWithPrefix(word); // 查找单词的前缀节点
        return node != null && node.isEnd; // 如果前缀节点存在且标记为单词结束，则返回 true
    }

    // 查找字典树中是否有以指定前缀开头的单词
    public boolean startsWith(String prefix) {
        return startsWithPrefix(prefix) != null; // 前缀节点存在则返回 true
    }

    // 查找指定前缀对应的节点
    private Node startsWithPrefix(String prefix) {
        Node node = root; // 从根节点开始
        for (int i = 0; i < prefix.length(); i++) {
            node = node.children[prefix.charAt(i) - 'a']; // 移动到下一个节点
            if (node == null) {
                return null; // 如果节点不存在，返回 null
            }
        }
        return node; // 返回前缀对应的节点
    }
}

// 节点类
class Node {
    Node[] children; // 子节点数组
    boolean isEnd;   // 是否为单词结束标记

    // 构造函数，初始化子节点数组和结束标记
    public Node() {
        children = new Node[26]; // 26 个字母的子节点
        isEnd = false; // 默认不是单词结束
    }
}
