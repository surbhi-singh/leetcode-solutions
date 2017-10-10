class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int num: nums){
            xor = xor^num;
        }
        int bit = xor & ~(xor-1);
        int xor1=0, xor0=0;
        for(int num: nums){
            if((num & bit) == 0)
                xor0 = xor0 ^ num;
            else
                xor1 = xor1 ^ num;
        }
        return new int[] {xor1, xor0};
    }
}
