class Solution {
    public boolean canJump(int[] nums) {
        int minTrueIndex = nums.length-1;
        for(int i=nums.length-2; i>=0; i--) {
            if(i + nums[i] >= minTrueIndex) {
                minTrueIndex = i;
            }
        }
        return (minTrueIndex == 0) ? true : false;
    }
}
