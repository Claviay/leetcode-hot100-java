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
   public ListNode reverseKGroup(ListNode head, int k) {
       // 判断当前长度是否小于k
       ListNode p0 = head;
       for (int i = 0; i < k; i++) {
           if (p0 == null) return head;
           p0 = p0.next;
       }
       // 翻转k个链表
       ListNode pre = null, cur = head, temp;
       for (int i = 0; i < k; i++) {
           temp = cur.next;
           cur.next = pre;
           pre = cur;
           cur = temp;
       }
       // 继续检索下一组

       //下面这个是核心重要的地方
       head.next = reverseKGroup(cur, k);
       return pre;
   }
}
