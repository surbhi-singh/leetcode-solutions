class Solution {
    public int maxSubArray(int[] nums) {
        int sum=Integer.MIN_VALUE;
        if(nums.length == 0)
            return 0;
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            if(res[i-1] + nums[i] > nums[i]){
                res[i] = res[i-1]+nums[i];
            }
            else
                res[i] = nums[i];
        }
        for(int i=0; i<nums.length; i++){
            if(sum<res[i])
                sum = res[i];
        }
        return sum;

    }
}