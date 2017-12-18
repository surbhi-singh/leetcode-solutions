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
    private StringBuilder constructTree(TreeNode t) {
        if(t == null) {
            return new StringBuilder("");
        }
        else {
            StringBuilder str = new StringBuilder();
            str.append(t.val);
            if(t.left == null && t.right != null) {
                str.append("()");
            }
            else if(t.left != null) {
                str.append("(" + constructTree(t.left) + ")");
            }
            if(t.right != null) {
                str.append("(" + constructTree(t.right) + ")");
            }
            return str;
        }
    }
    public String tree2str(TreeNode t) {
        return constructTree(t).toString();
    }
}
