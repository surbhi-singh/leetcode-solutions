class Solution {
    public int strStr(String haystack, String needle) {
        int i=-1, j;
        if(needle.length() == 0)
            return 0;
        else if(needle.length() > haystack.length())
            return -1;
        for(i=0; i<=haystack.length()-needle.length(); i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                for(j=1; j<needle.length(); j++){
                    if(haystack.charAt(i+j) != needle.charAt(j)){
                        break;
                    }
                }
                if(j == needle.length())
                    return i;
            }
        }
        return -1;
    }
}