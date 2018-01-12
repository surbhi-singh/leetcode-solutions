/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        else {
            if(head == head.next) return true;
            else {
                ListNode ptr = head, nextnode = head;
                while(nextnode != null && nextnode.next != null) {
                    ptr = ptr.next;
                    nextnode = nextnode.next.next;
                    if(ptr == nextnode) return true;
                }
                return false;
            }
        }
    }
}
