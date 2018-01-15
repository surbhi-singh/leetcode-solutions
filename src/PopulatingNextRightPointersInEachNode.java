/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        else {
            TreeLinkNode current = root;
            while(current != null) {
                TreeLinkNode ptr = current;
                while(ptr != null) {
                    if(ptr.left != null) ptr.left.next = ptr.right;
                    if(ptr.right != null && ptr.next != null) ptr.right.next = ptr.next.left;
                    ptr = ptr.next;
                }
                current = current.left;
            }
        }
    }
}
