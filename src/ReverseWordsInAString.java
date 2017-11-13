public class Solution {
    public String reverseWords(String s) {
        if(s.trim().length() == 0 || s == null)
            return "";
        else {
            StringBuilder res = new StringBuilder();
            String[] str = s.trim().split(" ");
            for(int i=str.length-1; i>=0; i--) {
                if(str[i].trim().length() != 0) {
                    res.append(str[i].trim());
                    res.append(" ");
                }
            }
            res.deleteCharAt(res.length()-1);
            return res.toString();
        }
    }
}
