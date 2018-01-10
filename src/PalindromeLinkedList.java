import java.math.BigInteger;
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
            StringBuilder halflist = new StringBuilder("");
            ListNode ptr = head;
            int length=0, counter=0;
            while(ptr != null) {
                length++;
                ptr = ptr.next;
            }
            ptr = head;
            while(counter < length/2) {
                halflist.append(ptr.val+" ");
                ptr = ptr.next;
                counter++;
            }
            if(length % 2 != 0) ptr = ptr.next;
            String[] vallist = new String[counter];
            vallist = halflist.toString().split(" ");
            while(ptr != null) {
                if(!vallist[--counter].equals(ptr.val+"")) return false;
                ptr = ptr.next;
            }
            return true;
        }
    }
}
