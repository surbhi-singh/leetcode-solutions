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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null)
            return list;
        else{
            queue.add(root);
            int size = queue.size();
            while(size != 0){
                Double sum=0.0;
                int count = size;
                while(size != 0){
                    TreeNode node = queue.poll();
                    if(node.left != null)
                        queue.add(node.left);
                    if(node.right != null)
                        queue.add(node.right);
                    sum+=node.val;
                    size--;
                }
                list.add(sum/count);
                size = queue.size();
            }
            return list;
        }
    }
}
