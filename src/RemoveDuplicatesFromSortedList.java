/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;
        else{
            ListNode ptr = head.next;
            ListNode prev = head;
            while(ptr != null){
                if(ptr.val == prev.val){
                    prev.next = ptr.next;
                    ptr = ptr.next;
                }
                else{
                    prev = ptr;
                    ptr = ptr.next;
                }
            }
            return head;
        }

    }
}