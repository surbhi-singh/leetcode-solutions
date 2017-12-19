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
    private int maxVal(TreeNode root) {
        if(root == null) {
            return Integer.MIN_VALUE;
        }
        else {
            int max = Math.max(root.val, maxVal(root.left));
            return Math.max(max, maxVal(root.right));
        }
    }
    private int minVal(TreeNode root) {
        if(root == null) {
            return Integer.MAX_VALUE;
        }
        else {
            int min = Math.min(root.val, minVal(root.left));
            return Math.min(min, minVal(root.right));
        }
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        else {
            if(root.left != null && root.right != null) {
                if(root.val > maxVal(root.left) && root.val < minVal(root.right)) {
                    return isValidBST(root.left) && isValidBST(root.right);
                }
                else {
                    return false;
                }
            }
            else if(root.left != null) {
                if(root.val > maxVal(root.left)) {
                    return isValidBST(root.left);
                }
                else {
                    return false;
                }
            }
            else if(root.right != null) {
                if(root.val < minVal(root.right)) {
                    return isValidBST(root.right);
                }
                else {
                    return false;
                }
            }
            else {
                return true;
            }
        }
    }
}
