class Solution {
    public int minMoves(int[] nums) {
        int count=0, sum=0, min=Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            if(min > nums[i])
                min = nums[i];
            sum+=nums[i];
        }
        return sum-(min*nums.length);
    }
}
