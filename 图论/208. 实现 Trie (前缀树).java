class Trie {
    // 定义前缀树的根节点
    private Node root;

    // 构造函数，初始化根节点
    public Trie() {
        root = new Node();
    }
    
    // 插入单词到前缀树中
    public void insert(String word) {
        Node node = root;      // 从根节点开始构造这个word对应的路径节点
        int n = word.length();
        // 遍历单词的每个字符
        for (int i = 0; i < n; i++) {
            // 将当前字符转换为子节点的索引
            int id = word.charAt(i) - 'a'; 
            // 如果当前字符对应的子节点不存在，则创建新节点
            if (node.children[id] == null) {
                node.children[id] = new Node();
            }
            // 移动到下一个子节点，继续处理下一个字符
            node = node.children[id];
        }
        // 设置最后一个节点的isEnd标志为true，表示这是一个完整的单词
        node.isEnd = true;
    }
    
    // 查找前缀树中是否存在这个完整单词
    
    // search在startsWith的基础上，必须得是尾节点!!!!!!!!!!!!!!!
    public boolean search(String word) {
        // 调用searchPrefix函数找到最后匹配的节点
        Node node = searchPrefix(word);
        // 如果返回的节点不为空且是尾节点，说明找到了这个完整的单词
        return node != null && node.isEnd;
    }
    

    // 判断是否存在以给定前缀开头的单词
    public boolean startsWith(String prefix) {
        // 如果searchPrefix返回的节点不为空，说明包含这个前缀
        return searchPrefix(prefix) != null;
    }
    
    // 私有方法：查找给定字符串前缀对应的最后一个节点
    private Node searchPrefix(String word) {
        Node node = root;  // 从根节点依次开始匹配每个字符
        int n = word.length();
        // 遍历字符串中的每个字符
        for (int i = 0; i < n; i++) {
            // 根据当前字符获取对应的子节点
            node = node.children[word.charAt(i) - 'a']; 
            
            // 如果节点为空，说明前缀不匹配，直接返回null
            if (node == null) {
                return null;
            }
        }
        // 返回最后一个匹配的节点
        return node;
    }
}



// 前缀树的节点类
class Node {
    // 每个节点最多有26个子节点，表示26个英文字母
    Node[] children;  
    // 标记是否是单词的末尾节点
    boolean isEnd;

    // 构造函数，初始化节点(new的时候就构造成功了!!!!)
    public Node() {
        children = new Node[26];  // 初始化26个子节点
        isEnd = false;  // 默认不是单词的末尾
    }
}
