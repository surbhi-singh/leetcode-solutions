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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
            return 0;
        else if(root.left == null)
            return sumOfLeftLeaves(root.right);
        else{
                int x = sumOfLeftLeaves(root.left);
                if(x == 0 && root.left.right == null && root.left.left == null)
                    return (root.left.val+sumOfLeftLeaves(root.right));
                else
                    return (x+sumOfLeftLeaves(root.right));
            }
        }
    }
