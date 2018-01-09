class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows <= 0) return result;
        List<Integer> prev = new ArrayList<>();
        for(int i=0; i<numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j=1; j<i; j++) {
                if(prev != null) {
                    temp.add(prev.get(j-1) + prev.get(j));
                }
            }
            if(i != 0) temp.add(1);
            result.add(temp);
            prev = temp;
        }
        return result;
    }
}
