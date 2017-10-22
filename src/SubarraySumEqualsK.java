class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums.length == 0 || nums == null)
            return 0;
        else {
            int[] dp = new int[nums.length];
            int count=0;
            for(int i=0; i<nums.length; i++) {
                for(int j=i; j<nums.length; j++) {
                    if(i == j) {
                        dp[j] = nums[j];
                    }
                    else {
                        dp[j] = dp[j-1] + nums[j];
                    }
                    if(dp[j] == k)
                        count++;
                }
            }
            return count;
        }
    }
}
