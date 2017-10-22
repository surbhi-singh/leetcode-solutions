class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(k == 0){
            for(int i=0; i<nums.length-1; i++) {
                if(nums[i] == 0 && nums[++i] == 0)
                    return true;
            }
            return false;
        }
        if(nums.length == 0 || nums == null)
            return false;
        int[] dp = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            for(int j=i; j<nums.length; j++) {
                if(i == j)
                    dp[j] = nums[j];
                else {
                    dp[j] = dp[j-1] + nums[j];
                    if(dp[j]%k == 0)
                        return true;
                }
            }
        }
        return false;
    }
}
