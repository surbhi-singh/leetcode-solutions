class Solution {
    public String reverseWords(String s) {
        if(s.length() == 0)
            return s;
        else{
            String[] str = s.trim().split(" ");
            StringBuilder strbuilder = new StringBuilder();
            for(int i=0; i<str.length; i++){
                strbuilder.append(new StringBuilder(str[i]).reverse());
                strbuilder.append(" ");
            }
            return strbuilder.toString().trim();
        }
    }
}
