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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return root;
        else if(root.val == key){
            if(root.left == null && root.right == null)
                return null;
            else if(root.left == null && root.right != null)
                return root.right;
            else if(root.left != null && root.right == null)
                return root.left;
            else{
                TreeNode leftptr = root.left;
                root = root.right;
                if(root.left == null) {
                    root.left = leftptr;
                    return root;
                } else {
                    TreeNode rootleft = root.left;
                    root.left = leftptr;
                    while(leftptr.right != null)
                        leftptr = leftptr.right;
                    leftptr.right = rootleft;
                }
            }
        }
        else if(root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }
}
