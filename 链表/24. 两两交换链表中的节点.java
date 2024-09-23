/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        // 如果链表为空或者只有一个节点，直接返回头节点
        if (head == null || head.next == null) {
            return head;
        }

        // 创建一个虚拟节点，指向链表的头部
        ListNode fake = new ListNode(0);
        fake.next = head;
        // 初始化指针，用于遍历链表
        ListNode current = fake;

        // 当当前节点的下一个节点和下下个节点都存在时，进行交换
        while (current.next != null && current.next.next != null) {
            // 定义两个要交换的节点
            ListNode first = current.next;
            ListNode second = current.next.next;

            // 交换这两个节点
            first.next = second.next;
            second.next = first;
            current.next = second;

            // 移动指针，继续处理下一个一对节点
            current = first;
        }

        // 返回交换后的新头节点
        return fake.next;
    }
}

/*
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        else {
            ListNode next = head.next;
            head.next = swapPairs(next.next);
            next.next = head;
            return next;
        }
    }
}
*/
