class Solution {
    public int removeDuplicates(int[] nums) {
        int nextelement=0;
        if(nums.length == 1)
            return 1;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] != nums[i+1]){
                nums[++nextelement] = nums[i+1];
                // nextelement++;
            }
        }
        return nextelement+1;

    }
}