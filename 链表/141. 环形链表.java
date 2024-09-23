public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false; // 如果链表为空或只有一个节点，则不可能有环
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false; // 如果快指针到达链表末尾，则没有环
            }

            slow = slow.next; // 慢指针移动一步
            fast = fast.next.next; // 快指针移动两步
        }

        return true; // 如果慢指针和快指针相遇，则有环
    }
}
