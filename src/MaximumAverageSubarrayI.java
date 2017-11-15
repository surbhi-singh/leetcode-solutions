class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double avg=0, sum=0;
        if(nums == null || nums.length == 0 || k > nums.length) {
            return avg;
        }
        else {
            for(int i=0; i<k; i++) {
                sum += nums[i];
            }
            avg = sum/k;
            for(int i=1; i<nums.length-k+1; i++) {
                sum -= nums[i-1];
                sum += nums[i+k-1];
                if(avg < (sum/k)) {
                    avg = sum/k;
                }
            }
            return avg;
        }

    }
}
