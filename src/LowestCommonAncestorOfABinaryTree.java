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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        else if(root == p || root == q)
            return root;
        else{
            TreeNode tempL = lowestCommonAncestor(root.left, p, q);
            TreeNode tempR = lowestCommonAncestor(root.right, p, q);
            if(tempL != null && tempR != null)
                return root;
            else if(tempL != null)
                return tempL;
            else if(tempR != null)
                return tempR;
            else
                return null;

        }

    }
}
