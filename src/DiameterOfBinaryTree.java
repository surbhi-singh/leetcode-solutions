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
    int sum;
    private int calculateDiameter(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return 0;
        else {
            int leftroot = calculateDiameter(root.left);
            int rightroot = calculateDiameter(root.right);
            int max = 1 + Math.max(leftroot, rightroot);
            if(sum < 2 + leftroot + rightroot) sum = leftroot + rightroot + ((root.left == null)?0:1) + ((root.right == null)?0:1);
            return max;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        sum=0;
        calculateDiameter(root);
        return sum;
    }
}
