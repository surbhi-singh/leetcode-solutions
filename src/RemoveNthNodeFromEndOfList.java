/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ptr = head;
        ListNode prev = head;
        int count=0;
        while(count < n) {
            ptr = ptr.next;
            count++;
        }
        if(ptr == null) {
            return head.next;
        }
        while(ptr.next != null) {
            ptr = ptr.next;
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return head;
    }
}
