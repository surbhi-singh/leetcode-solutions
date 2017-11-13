class Solution {
    public int countSubstrings(String s) {
        if(s == null || s.trim().length() == 0)
            return 0;
        else {
            int count = 0;

            for(int i=1; i<s.length(); i++) {

                //for even palins
                int start = i-1, end = i;
                while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                    count++;
                    start--;
                    end++;
                }

                //for odd palins
                start = i-1;
                end = i+1;
                while(start >= 0 && end <s.length() && s.charAt(start) == s.charAt(end)) {
                    count++;
                    start--;
                    end++;
                }
            }
            count += s.length();
            return count;
        }
    }
}
