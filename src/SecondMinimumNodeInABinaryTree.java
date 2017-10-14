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
    public int findSecondMinimumValue(TreeNode root) {
        int val, val2;
        if(root.left == null && root.right == null)
            return -1;
        else if(root.left.val != root.right.val){
            val = Math.max(root.left.val, root.right.val);
            if(root.left.val > root.right.val) {
                val2 = findSecondMinimumValue(root.right);
            }
            else{
                val2 = findSecondMinimumValue(root.left);
            }
        }
        else{
            val = findSecondMinimumValue(root.left);
            val2 = findSecondMinimumValue(root.right);
        }
        if(val == -1 && val2 == -1)
            return -1;
        else if(val == -1 && val2 != -1)
            return val2;
        else if(val != -1 && val2 == -1)
            return val;
        else
            return Math.min(val, val2);
    }
}
