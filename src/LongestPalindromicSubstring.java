class Solution {
    public String longestPalindrome(String s) {
        String result = new String();
        if(s == null || s.trim().length() == 0)
            return result;
        else {
            int maxLength=1, startIndex = 0;
            for(int i=1; i<s.length(); i++) {
                //for odd palins
                int start = i-1, end = i+1, count=1;
                while(start >= 0 && end <s.length() && s.charAt(start) == s.charAt(end)) {
                    count += 2;
                    if(count > maxLength) {
                        maxLength = count;
                        startIndex =start;
                    }
                    start--;
                    end++;
                }

                //for even palins
                start = i-1;
                end = i;
                count = 0;
                while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                    count +=2;
                    if(count > maxLength) {
                        maxLength = count;
                        startIndex = start;
                    }
                    start--;
                    end++;
                }
            }
            return s.substring(startIndex, startIndex+maxLength);
        }
    }
}
