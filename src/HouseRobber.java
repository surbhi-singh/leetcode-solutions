class Solution {
    public int maximum(int a, int b){
        if(a>=b)
            return a;
        else
            return b;
    }
    public int rob(int[] nums) {
        int[] totalMoney = new int[nums.length];
        int i;
        if(nums.length == 0)
            return 0;
        else if(nums.length ==1)
            return nums[0];
        totalMoney[0]=nums[0];
        totalMoney[1]=nums[1];
        for(i=2; i<nums.length;i++)
            totalMoney[i] = 0;
        for(i=2; i<nums.length; i++){
            totalMoney[i]=maximum((totalMoney[i-2]+nums[i]), (totalMoney[i-1]-nums[i-1]+nums[i]));
            System.out.println(totalMoney[i]);
        }
        return maximum(totalMoney[nums.length-1], totalMoney[nums.length-2]);

    }
}