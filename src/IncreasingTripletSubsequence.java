class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length <= 2) return false;
        else {
            int leftmin = Integer.MAX_VALUE, rightmin = Integer.MAX_VALUE;
            for(int i=0, count=0; i<nums.length-1; i++) {
                if(nums[i] < nums[i+1]) {
                    if(rightmin == Integer.MAX_VALUE || nums[i+1] > nums[rightmin]) {
                        count++;
                    }
                    if(leftmin == Integer.MAX_VALUE || nums[i] < nums[leftmin]) {
                        leftmin = i;
                    }
                    if(rightmin == Integer.MAX_VALUE || nums[i+1] < nums[rightmin]) {
                        rightmin = i+1;
                    }
                }
                else if(rightmin != Integer.MAX_VALUE && leftmin != Integer.MAX_VALUE){
                    if(nums[i+1] < nums[rightmin]) {
                        if(nums[i+1] > nums[leftmin]) {
                            rightmin = i+1;
                        }
                    }
                }
                if(count == 2) return true;
            }
            return false;
        }
    }
}
