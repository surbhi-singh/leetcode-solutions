class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length, degree = Integer.MIN_VALUE, element=0;
        for(int i=0; i<len; i++) {
            if(map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i])+1);
            else map.put(nums[i], 1);
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() > degree)
            {
                degree = entry.getValue();
                element = entry.getKey();
            }
        }
        return element;
    }
}
