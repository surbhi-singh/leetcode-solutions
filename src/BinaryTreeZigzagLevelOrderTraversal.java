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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        s.push(root);
        int i=0;
        while(!s.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<TreeNode>();
            if(i%2 == 0) {
                while(!s.isEmpty()) {
                    TreeNode node = s.pop();
                    list.add(node.val);
                    if(node.left != null) stack.push(node.left);
                    if(node.right != null) stack.push(node.right);
                }
            }
            else {
                while(!s.isEmpty()) {
                    TreeNode node = s.pop();
                    list.add(node.val);
                    if(node.right != null) stack.push(node.right);
                    if(node.left != null) stack.push(node.left);
                }
            }
            s = stack;
            result.add(list);
            i++;
        }
        return result;
    }
}
