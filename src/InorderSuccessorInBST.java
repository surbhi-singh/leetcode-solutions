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
    TreeNode successor;
    int min;
    private void inorder(TreeNode root, TreeNode p) {
        if(root == null) return;
        else {
            inorder(root.left, p);
            if(root.val > p.val && root.val < min) {
                min = root.val;
                successor = root;
            }
            inorder(root.right, p);
        }
    }
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        successor = null;
        if(p == null) return successor;
        min = Integer.MAX_VALUE;
        inorder(root, p);
        return successor;
    }
}
