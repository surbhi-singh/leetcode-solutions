class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        if(k < 0 || k > n) return combinations;
        else if(k == 0) combinations.add(new ArrayList<Integer>());
        else {
            combinations = combine(n-1, k-1);
            combinations.forEach(e -> e.add(n));
            combinations.addAll(combine(n-1, k));
        }
        return combinations;
    }
}
