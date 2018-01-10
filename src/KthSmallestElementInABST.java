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
    List<Integer> list;
    int givenk;
    private int findSmallest(TreeNode root) {
        if(root == null) return 0;
        else {
            if(findSmallest(root.left) == -1) return -1;
            else {
                list.add(root.val);
                if(list.size() == givenk) {
                    return -1;
                }
                if(findSmallest(root.right) == -1) return -1;
                else return 0;
            }
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        list = new ArrayList<>();
        givenk = k;
        findSmallest(root);
        return list.get(list.size()-1);
    }
}
