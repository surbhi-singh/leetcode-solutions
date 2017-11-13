class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for(int i=0; i<nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            }
            else {
                int count = map.get(nums[i]) + 1;
                map.put(nums[i], count);
                if( max < count)
                    max = count;
            }
        }
        ArrayList<Integer>[] arr = (ArrayList<Integer>[])new ArrayList[max+1];
        for(int i=1; i<= max; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
                arr[entry.getValue()].add(entry.getKey());
        }
        for(int i= arr.length-1; k>0 && i>=0; i--) {
            if(arr[i].size() != 0) {
                List<Integer> list = arr[i];
                for(int j=0; j<list.size() && k>0; j++) {
                    result.add(list.get(j));
                    k--;
                }
            }
        }
        return result;
    }
}
