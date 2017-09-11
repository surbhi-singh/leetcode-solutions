class Solution {
    public String longestCommonPrefix(String[] strs) {
        int min=Integer.MAX_VALUE, flag=0;
        StringBuilder res = new StringBuilder("");
        for(int i=0; i<strs.length; i++){
            if(min > strs[i].length())
                min = strs[i].length();
        }
        if(min == Integer.MAX_VALUE)
            min=0;
        for(int i=0; i<min; i++){
            flag=0;
            for(int j=0; j<strs.length-1;j++){
                if(!(strs[j].charAt(i) == strs[j+1].charAt(i))){
                    flag = 1;
                    break;
                }
            }
            if(flag == 1)
                break;
            res.append(strs[0].charAt(i));
        }
        return res.toString();
    }
}