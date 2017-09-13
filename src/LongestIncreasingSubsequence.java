class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] len = new int[nums.length];
        int i, j, max=0;
        for(i=0; i<len.length; i++)
            len[i] = 1;
        for(i=1; i<nums.length; i++){
            for(j=i-1; j>=0; j--){
                if(nums[i] > nums[j]){
                    len[i] = Math.max(len[j]+1, len[i]);
                }
            }
        }
        for(i=0; i<len.length; i++){
            if(max < len[i])
                max = len[i];
        }
        return max;

    }
}