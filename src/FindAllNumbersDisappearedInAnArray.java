class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        else {
            for(int i=0; i<nums.length; i++) {
                int temp = Math.abs(nums[i]) - 1;
                nums[temp] = -Math.abs(nums[temp]);
            }
            for(int i=0; i<nums.length; i++) {
                if(nums[i] > 0) result.add(i+1);
            }
            return result;
        }
    }
}
