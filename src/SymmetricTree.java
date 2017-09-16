/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSym(TreeNode leftnode, TreeNode rightnode){
        if(leftnode == null && rightnode == null)
            return true;
        if((leftnode == null && rightnode != null) || (leftnode != null && rightnode == null))
            return false;
        if(leftnode.val != rightnode.val)
            return false;
        else{
            return (isSym(leftnode.left, rightnode.right) && isSym(leftnode.right, rightnode.left));
        }
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        if(root.left == null && root.right == null)
            return true;
        return isSym(root.left, root.right);

    }
}