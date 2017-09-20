class Solution {
    public String reverseVowels(String s) {
        StringBuilder str = new StringBuilder(s);
        StringBuilder strRev = new StringBuilder(s);
        int i=0, j=s.length()-1;
        String vowels = "aeiouAEIOU";
        System.out.println(i + " "+ j);
        while(i<j){
            if(vowels.contains(str.charAt(i)+"")){
                while(!vowels.contains(strRev.charAt(j)+"")){
                    j--;
                }
                char temp = str.charAt(i);
                str.setCharAt(i, strRev.charAt(j));
                str.setCharAt(j, temp);
                j--;
                System.out.println(temp + " "+ str.charAt(i));
            }
            i++;
        }
        return str.toString();
    }
}
