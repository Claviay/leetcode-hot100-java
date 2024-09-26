class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // 第一遍遍历：创建新节点并插入到原节点之后
        // 1 -> 1' -> 2 -> 2' -> 3 -> 3' -> null
        Node current = head;
        while (current != null) {
            Node newNode = new Node(current.val);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next; // 移动到下一个原节点
        }

        // 第二遍遍历：设置新节点的 random 指针

        current = head;
        while (current != null) {
            if (current.random != null) {
                // 这里的current.next是新节点
                current.next.random = current.random.next; // 设置新节点的 random 指向
            }
            current = current.next.next; // 跳过新节点，移动到下一个原节点
        }

        // 第三遍遍历：分离新链表和原链表
        // 1 -> 1' -> 2 -> 2' -> 3 -> 3' -> null
        current = head;
        Node suoyin = head.next;
        while (current != null) {
            Node newNode = current.next; // 新节点
            current.next = newNode.next; // 恢复原链表的 next 指针
            if (newNode.next != null) {
                newNode.next = newNode.next.next; // 设置新链表的 next 指针
            }
            current = current.next; // 移动到下一个原节点
        }

        return suoyin; // 返回新链表的头节点
    }
}
