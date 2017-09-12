/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        else if(l2 == null)
            return l1;
        else if(l1 == null && l2 == null)
            return null;
        else{
            ListNode resultList = new ListNode(0);
            ListNode head = resultList;
            ListNode ptr = resultList;
            if(l1.val <= l2.val){
                ptr.val = l1.val;
                ptr.next = mergeTwoLists(l1.next, l2);
            }
            else{
                ptr.val = l2.val;
                ptr.next = mergeTwoLists(l1, l2.next);
            }
            return head;
        }

    }
}