class Solution {
    public int lengthOfLastWord(String s) {
        int i=0, count=0;
        s = s.trim();
        if(s.length() == 0)
            return 0;
        else{
            String[] splittedStr = s.split(" ");
            return splittedStr[splittedStr.length-1].length();
        }
    }
}