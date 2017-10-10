class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length == 0)
            return 0;
        int ans=0;
        for(int i=0; i<32; i++){
            int count=0;
            for(int j=0; j<nums.length; j++){
                if(((nums[j] >> i) & 1) == 1)
                    count++;
                count = count % 3;
            }
            if(count != 0)
                ans = ans | (count << i);
        }
        return ans;

    /*METHOD 1 Using HashMap
        HashMap<Integer, Integer> map = new HashMap<>();
        if(nums.length == 0)
            return 0;
        else if(nums.length == 1)
            return 1;
        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i], 1);
            else
                map.put(nums[i], map.get(nums[i])+1);
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() == 1)
                return entry.getKey();
        }
        return -1;
        */

    /* METHOD 2 Using Sorting
        if(nums.length == 0)
            return 0;
        else if(nums.length == 1)
            return nums[0];
        Arrays.sort(nums);
        int i=0;
        for(i=0; i<nums.length-1; i++){
            if(nums[i] == nums[i+1])
                i = i+2;
            else{
                return nums[i];
            }

        }
        if(i == nums.length-1)
            return nums[i];
       return 0;
       */
    }
}
