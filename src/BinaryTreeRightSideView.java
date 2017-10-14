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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        queue.offer(root);
        queue.offer(null);
        list.add(root.val);
        while(!queue.isEmpty()) {
            while(queue.peek() != null) {
                TreeNode node = queue.poll();
                if(node.right != null) queue.offer(node.right);
                if(node.left != null) queue.offer(node.left);
            }
            queue.poll();
            if(!queue.isEmpty()) {
                TreeNode ptr = queue.peek();
                list.add(ptr.val);
                queue.offer(null);
            }
        }
        return list;
    }
}
