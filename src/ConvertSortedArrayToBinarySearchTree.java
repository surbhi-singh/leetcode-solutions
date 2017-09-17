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
    public TreeNode formBST(int[] nums, int low, int high){
        TreeNode node = new TreeNode(0);
        if(low > high)
            return null;
        if(low == high){
            node.val = nums[low];
            return node;
        }
        else{
            int mid = (low+high)/2;
            node.val = nums[mid];
            node.left = formBST(nums, low, mid-1);
            node.right = formBST(nums, mid+1, high);
            return node;
        }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode node = null;
        if(nums.length == 0)
            return node;
        TreeNode head = formBST(nums, 0, nums.length-1);
        return head;

    }
}
