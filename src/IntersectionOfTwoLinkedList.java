/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode, ListNode> map = new HashMap<>();
        ListNode ptr = headA;
        while(ptr != null){
            map.put(ptr, ptr.next);
            ptr = ptr.next;
        }
        ptr = headB;
        while(ptr != null){
            if(map.containsKey(ptr))
                return ptr;
            ptr = ptr.next;
        }
        return null;
    }
}
