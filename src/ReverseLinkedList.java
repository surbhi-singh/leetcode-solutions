/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode ptr = head.next.next;
        ListNode prev = head.next;
        ListNode pprev = head;
        while( ptr != null){
            prev.next = pprev;
            pprev = prev;
            prev = ptr;
            ptr=ptr.next;
        }
        prev.next = pprev;
        head.next = null;
        head = prev;
        return head;
    }
}
