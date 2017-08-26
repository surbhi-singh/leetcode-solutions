/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode(0);
        ListNode head = newNode;
        ListNode ptr = newNode;
        int carry = 0, tempSum = 0;
        while(l1 != null || l2 != null)
        {
            newNode = new ListNode(0);
            newNode.next = null;
            if(l1 == null)
            {
                tempSum = l2.val + carry;
                l2 = l2.next;
            }
            else if(l2 == null)
            {
                tempSum = l1.val + carry;
                l1 = l1.next;
            }
            else
            {
                tempSum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }
            if(tempSum <= 9)
            {
                newNode.val = tempSum;
                carry = 0;
            }
            else
            {
                newNode.val = tempSum%10;
                carry = tempSum/10;
            }
            ptr.next = newNode;
            ptr = newNode;
        }
        if(carry != 0)
        {
            newNode = new ListNode(0);
            newNode.val = carry;
            newNode.next = null;
            ptr.next = newNode;
        }
        return head.next;

    }
}