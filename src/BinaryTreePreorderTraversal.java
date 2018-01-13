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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<Integer>();
        if(root == null) return preorder;
        else {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while(!stack.isEmpty()) {
                TreeNode node = stack.pop();
                preorder.add(node.val);
                if(node.right != null) stack.push(node.right);
                if(node.left != null) stack.push(node.left);
            }
            return preorder;
        }
    }
}
