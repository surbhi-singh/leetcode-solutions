class Solution {
    public String reverseVowels(String s) {
        StringBuilder str = new StringBuilder(s);
        StringBuilder strRev = new StringBuilder(s);
        int i=0, j=s.length()-1;
        System.out.println(i + " "+ j);
        while(i<j){
            if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u'                             ||str.charAt(i) == 'A' || str.charAt(i) == 'E' || str.charAt(i) == 'I' || str.charAt(i) == 'O' || str.charAt(i) == 'U'){
                while(!(strRev.charAt(j) == 'a' || strRev.charAt(j) == 'e' || strRev.charAt(j) == 'i' || strRev.charAt(j) == 'o' ||                                     strRev.charAt(j) == 'u' || strRev.charAt(j) == 'A' || strRev.charAt(j) == 'E' || strRev.charAt(j) == 'I' ||                                     strRev.charAt(j) == 'O' || strRev.charAt(j) == 'U')){
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
