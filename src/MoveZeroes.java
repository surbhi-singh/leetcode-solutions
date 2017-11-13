class Solution {
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        while(i<j) {
            nums[i] = nums[++i];
        }
        nums[j] = temp;
    }
    public void moveZeroes(int[] nums) {
        for(int i=nums.length-1; i>=0; i--) {
            if(nums[i] != 0) {
                int nonZeroIndex = i;
                i--;
                while(i>=0 && nums[i] != 0) {
                    i--;
                }
                if(i>=0) {
                    swap(nums, i, nonZeroIndex);
                    i = nonZeroIndex;
                }
            }
        }
    }
}
