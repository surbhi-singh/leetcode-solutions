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
    public Boolean findValue(TreeNode root, HashSet<Integer> set, int k){
        if(root == null)
            return false;
        else{
            if(!set.isEmpty() && set.contains(root.val))
                return true;
            else{
                set.add(k-root.val);
                return findValue(root.left, set, k) || findValue(root.right, set, k);
            }
        }
    }
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return findValue(root, set, k);
    }
}
