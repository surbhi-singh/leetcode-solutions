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
    public static List<Integer> inorder(TreeNode root, List<Integer> list){
         if(root == null)
            return list;
        else{
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
            return list;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list = inorder(root, list);
        return list;
    }
}
