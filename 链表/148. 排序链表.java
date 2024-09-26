
class Solution {
    public ListNode sortList(ListNode head) {
        // 1. 递归结束条件：链表为空或只有一个节点，直接返回
        if (head == null || head.next == null) {
            return head;
        }

        // 2. 找到链表的中间节点，分割链表成两部分
        ListNode mid = findMiddle(head);
        ListNode rightHead = mid.next;
        mid.next = null; // 将链表断开

        // 3. 递归排序左右两部分
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // 4. 合并已排序的左右两部分
        return merge(left, right);
    }

    // 找到链表的中间节点
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }

    // 合并两个有序链表
    private ListNode merge(ListNode l1, ListNode l2) {
        // ListNode dummy = new ListNode(0);
        // ListNode current = dummy;
        
        // while (l1 != null && l2 != null) {
        //     if (l1.val < l2.val) {
        //         current.next = l1;
        //         l1 = l1.next;
        //     } else {
        //         current.next = l2;
        //         l2 = l2.next;
        //     }
        //     current = current.next;
        // }

        // // 将剩余的节点接到合并链表的末尾
        // if (l1 != null) {
        //     current.next = l1;
        // } else {
        //     current.next = l2;
        // }
        // return dummy.next;

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } 
        else if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }

    }
    }
