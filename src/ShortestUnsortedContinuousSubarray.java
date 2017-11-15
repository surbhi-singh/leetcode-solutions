class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length == 0 || nums == null) {
            return 0;
        }
        else {
            int minIndex=Integer.MAX_VALUE, tempMin=-1, maxIndex=0, max=Integer.MIN_VALUE;
            for(int i=0, flag=0; i<nums.length-1; i++) {
                if(nums[i] > nums[i+1]) {
                    tempMin = i;
                    while(tempMin>0 && nums[i+1] < nums[tempMin-1]) {
                        tempMin--;
                    }
                    if(tempMin < minIndex) {
                        minIndex = tempMin;
                    }
                }
                if(minIndex != Integer.MAX_VALUE) {
                    if(nums[i] > nums[i+1]) {
                        maxIndex = i+1;
                        while(maxIndex<nums.length-1 && nums[i] > nums[maxIndex+1]) {
                            maxIndex++;
                        }
                        if(maxIndex > max) {
                            max = maxIndex;
                        }
                    }
                }
            }
            if(minIndex != Integer.MAX_VALUE) {
                return max-minIndex+1;
            }
            else {
                return 0;
            }
        }
    }
}
