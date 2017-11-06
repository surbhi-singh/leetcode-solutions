/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return head;
        else {
            ListNode ptr = head;
            ListNode prev = head;
            while(ptr != null && ptr.val == val) {
                head = head.next;
                ptr = head;
                prev = head;
            }
            while(ptr != null) {
                if(ptr.val == val) {
                    prev.next = ptr.next;
                    ptr = ptr.next;
                }
                else {
                    prev = ptr;
                    ptr = ptr.next;
                }
            }
            return head;
        }

    }
}
