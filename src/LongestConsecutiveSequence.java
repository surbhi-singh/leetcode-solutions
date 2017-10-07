class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        TreeSet<Integer> set = new TreeSet<Integer>();
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
                map.put(nums[i], 1);
        }
        Iterator it = set.iterator();
        int val = (int)it.next();
        int count=1;
        int max = count;
        while(it.hasNext()){
            int temp = (int)it.next();
            if(val+1 == temp){
                count += 1;
            }
            else
                count = 1;
            val = temp;
            if(count > max)
                max = count;
        }
        return max;
    }
}
