class Solution {
    int[] result;
    private int binarySearch(int[] nums, int low, int high, int target, int count) {
        while(low <= high) {
            int mid = (low+high)/2;
            if(nums[mid] == target) {
                if(count == 0) {
                    if(mid == 0 || nums[mid-1] != target) return mid;
                    else return binarySearch(nums, low, mid-1, target, count);
                }

                if(count == 1) {
                    if(mid == nums.length-1 || nums[mid+1] != target) return mid;
                    else return binarySearch(nums, low+1, high, target, count);
                }
            }
            else if(nums[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        if(nums == null || nums.length == 0) return new int[]{-1, -1};
        else {
            result[0] = binarySearch(nums, 0, nums.length-1, target, 0);
            result[1] = binarySearch(nums, 0, nums.length-1, target, 1);
            if(result[0] == -1) result[0] = result[1];
            if(result[1] == -1) result[1] = result[0];
            return result;
        }
    }
}
