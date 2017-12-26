class Solution {
    private boolean isPalindrome(String s, boolean charDeleted) {
        int length = s.length();
        if(s == null || length == 0) {
            return true;
        }
        else {
            for(int i=0, j=length-1; i<=j; i++, j--) {
                if(s.charAt(i) == s.charAt(j)) {
                    continue;
                }
                else if(charDeleted == false){
                    return isPalindrome(s.substring(i+1, j+1), true) || isPalindrome(s.substring(i, j), true);
                }
                else {
                    return false;
                }
            }
            return true;
        }
    }
    public boolean validPalindrome(String s) {
        return isPalindrome(s, false);
    }
}
