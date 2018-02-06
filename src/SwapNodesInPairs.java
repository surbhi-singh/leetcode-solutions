/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        else {

            ListNode ptr = head, t, prev = null;
            head = head.next;
            while(ptr != null && ptr.next != null) {
                if(prev != null) {
                    prev.next = prev.next.next;
                }
                t = ptr.next;
                ptr.next = t.next;
                t.next = ptr;
                prev = ptr;
                ptr = ptr.next;
            }
            return head;
        }
    }
}
