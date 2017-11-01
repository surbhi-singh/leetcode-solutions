class Solution {
    public boolean isSubsequence(String s, String t) {
        if(t.length() < s.length())
            return false;
        else {
            int j=0;
            for(int i=0; i<t.length() && j<s.length(); i++) {
                if(s.charAt(j) == t.charAt(i)) {
                    j++;
                }
            }
            if(j == s.length())
                return true;
            else
                return false;
        }
    }
}
