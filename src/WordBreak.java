class Solution {
    Set<String> set;
    int[][] exist;
    public boolean checkFunc(String s, int start, int end) {
        if(set.contains(s.substring(start, end))) {
            exist[start][end-1] = 1;
            return true;
        }
        else {
            for(int i=end-1; i>=start; i--) {
                if(set.contains(s.substring(start, i))) {
                    exist[start][i-1] = 1;
                    if(exist[i][end-1] == -1) {
                        return false;
                    }
                    else if(exist[i][end-1] == 1 || checkFunc(s, i, end)) {
                        exist[i][end-1] = 1;
                        return true;
                    }
                    else {
                        exist[i][end-1] = -1;
                    }
                }
            }
            return false;
        }
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>();
        exist = new int[s.length()][s.length()];
        for(int i=0; i<wordDict.size(); i++) {
            set.add(wordDict.get(i));
        }
        return checkFunc(s, 0, s.length());
    }
}
