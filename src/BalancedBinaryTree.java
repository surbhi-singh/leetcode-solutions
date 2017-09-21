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
    public int heightOf(TreeNode root){
        if(root == null)
            return 0;
        else if(root.left == null && root.right == null)
            return 1;
        else{
            return Math.max(1+heightOf(root.left), 1+heightOf(root.right));
        }
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        else if(root.left == null && root.right == null)
            return true;
        else{
            if(isBalanced(root.left) && isBalanced(root.right)){
                if(Math.abs(heightOf(root.left)-heightOf(root.right)) <= 1)
                    return true;
                else
                    return false;
            }
            else
                return false;
        }
    }
}
