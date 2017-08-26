class Solution {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;

        int returnIndex[] = {-1, -1};
        for(int i = 0; i<length-1; i++)
        {
            for(int j = i+1; j<length;j++)
            {
                if(nums[i]+nums[j] == target)
                {
                    returnIndex[0] = i;
                    returnIndex[1] = j;
                }
            }
        }
        return returnIndex;
    }
}