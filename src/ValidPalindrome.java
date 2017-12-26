class Solution {
    public boolean isPalindrome(String s) {
        int length = s.length();
        if(s == null || s.trim().length() == 0) {
            return true;
        }
        else {
            int i, j;
            for(i=0, j=length-1; i<=j; i++, j--) {
                while(!((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') ||(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || Character.isDigit(s.charAt(i)))) {
                    i++;
                    if(i == length) {
                        break;
                    }
                }
                while(!((s.charAt(j) >= 'a' && s.charAt(j) <= 'z') ||(s.charAt(j) >= 'A' && s.charAt(j) <= 'Z') || Character.isDigit(s.charAt(j)))) {
                    j--;
                    if(j < 0) {
                        break;
                    }
                }
                if(i >= length || j < 0) {
                    return true;
                }
                if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                    return false;
                }
            }

            return true;
        }
    }
}
