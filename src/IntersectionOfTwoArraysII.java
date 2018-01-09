class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] result = new int[Math.min(nums1.length, nums2.length)];
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for(int i=0; i<nums1.length; i++) {
            if(map1.containsKey(nums1[i])) map1.put(nums1[i], map1.get(nums1[i])+1);
            else map1.put(nums1[i], 1);
        }
        for(int i=0; i<nums2.length; i++) {
            if(map2.containsKey(nums2[i])) map2.put(nums2[i], map2.get(nums2[i])+1);
            else map2.put(nums2[i], 1);
        }
        int counter=0;
        for(Map.Entry<Integer, Integer> entry: map1.entrySet()) {
            if(map2.containsKey(entry.getKey())) {
                int count = Math.min(entry.getValue(), map2.get(entry.getKey()));
                for(int i=0; i<count; i++, counter++) result[counter] = entry.getKey();
            }
        }
        int[] res = new int[counter];
        for(int i=0; i<counter; i++) {
            res[i] = result[i];
        }
        return res;
    }
}
