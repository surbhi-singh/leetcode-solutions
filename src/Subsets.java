class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        if(nums.length == 0 || nums == null) {
            return result;
        }
        else {
            Queue<List<Integer>> queue = new LinkedList<List<Integer>>();
            for(int i=0; i<nums.length; i++) {
                List<Integer> numberList = new ArrayList<>();
                numberList.add(nums[i]);
                numberList.add(i);
                queue.add(numberList);
            }

            while(!queue.isEmpty()) {
                List<Integer> polledList = queue.poll();
                int startIndex = polledList.get(polledList.size()-1) + 1;
                polledList.remove(polledList.size()-1);

                result.add(polledList);

                for(int i=startIndex; i<nums.length; i++) {
                    List<Integer> listToAdd = new ArrayList<>();
                    listToAdd.addAll(polledList);
                    listToAdd.add(nums[i]);
                    listToAdd.add(i);
                    queue.add(listToAdd);
                }
            }
            return result;
        }

    }
}
