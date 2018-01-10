/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        else {
            ListNode ptr = head;
            int length=0, counter=0;
            while(ptr != null) {
                length++;
                ptr = ptr.next;
            }
            ptr = head;
            while(counter < length/2) {
                ptr = ptr.next;
                counter++;
            }
            ListNode end = ptr;
            if(length % 2 != 0) ptr = ptr.next;
            ListNode prev = ptr, fast = ptr.next;
            while(fast != null) {
                prev = fast;
                fast = fast.next;
                prev.next = ptr;
                ptr = prev;
            }
            fast = head;
            while(fast != end) {
                if(prev.val != fast.val) return false;
                fast = fast.next;
                prev = prev.next;
            }
            return true;
        }
    }
}
