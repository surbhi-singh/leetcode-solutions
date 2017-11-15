class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return false;
        else {
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for(int i=0; i<nums.length; i++) {
                if(!map.containsKey(nums[i])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(nums[i], list);
                }
                else {
                    List<Integer> list = map.get(nums[i]);
                    for(int j=0; j<list.size(); j++) {
                        if(Math.abs(i-list.get(j)) <= k) {
                            return true;
                        }
                    }
                    list.add(i);
                    map.put(nums[i], list);
                }
            }
            return false;
        }
    }
}
