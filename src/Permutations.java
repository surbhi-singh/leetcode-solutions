class Solution {
    private Set<List<Integer>> permutations;
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    private void findpermutations(int[] nums, int counter) {
        if(counter == nums.length) return;
        else{
            for(int i=counter; i<nums.length; i++) {
                swap(nums, counter, i);
                List<Integer> templist = Arrays.stream(nums).boxed().collect(Collectors.toList());
                permutations.add(templist);
                findpermutations(nums, counter+1);
                swap(nums, counter, i);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        permutations = new HashSet<>();
        if(nums == null || nums.length == 0) return new ArrayList(permutations);
        else {
            findpermutations(nums, 0);
            return new ArrayList(permutations);
        }
    }
}
