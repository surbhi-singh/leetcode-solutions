class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] product = new int[nums.length];
        int allproduct=1, countZero=0;
            for(int i=0; i<nums.length && countZero<2; i++) {
                if(nums[i] != 0) {
                    allproduct *= nums[i];
                }
                else countZero++;
            }
            for(int i=0; i<nums.length; i++) {
                if(countZero > 1 || (countZero == 1 && nums[i] != 0)) {
                    product[i] = 0;
                }
                else if(countZero == 1) product[i] = allproduct;
                else product[i] = allproduct / nums[i];
            }
        return product;
    }
}
