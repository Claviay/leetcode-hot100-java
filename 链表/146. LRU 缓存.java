//抽书

//设计双向链表
//mind 第一次知道链表也是可以设置两个值的
class ListNode {
    int key;
    int val;
    ListNode front, next;
    ListNode () {}
    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

//mind 我又想通过一个变量来记录个数了，但其实map.size()就可以知道个数
class LRUCache {
    int capacity;
    Map<Integer, ListNode> map;
    ListNode head, tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode();
        tail = new ListNode();

        // 尾巴前面是头， 头后面是尾巴
        head.next = tail;
        tail.front = head;
    }


    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode list = map.get(key);
            moveToPrimary(list);
            return list.val;
        } else {
            return -1;
        }
    }

    // 把书从下面抽出来放到最上边
    private void moveToPrimary(ListNode list) {
        // 断开结点
        list.front.next = list.next;
        list.next.front = list.front;

        // list变成头部
        head.next.front = list;
        list.next = head.next;

        // list已经头部了，然后head再插入头部
        list.front = head;
        head.next = list;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            if (map.size() == capacity) {
                moveTail();
            }
            ListNode newNode = new ListNode(key, value);
            /*tail.front.next = newNode;
            newNode.front = tail.front;
            newNode.next = tail;
            tail.front = newNode;*/
            //node 这个应该是插在头部
            newNode.next = head.next;
            head.next.front = newNode;

            //再把head放回头部
            newNode.front = head;
            head.next = newNode;
            map.put(key, newNode);
        } else {
            ListNode node = map.get(key);
            node.val = value;
            moveToPrimary(node);
        }
    }

    private void moveTail() {
        ListNode lastNode = tail.front;
        /*head.next.next.front = head;
        head.next = head.next.next;*/

        // 断开
        tail.front.front.next = tail;
        tail.front = tail.front.front;
        map.remove(lastNode.key);
    }
}
