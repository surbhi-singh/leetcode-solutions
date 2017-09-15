class Solution {
    public String addBinary(String a, String b) {
        if(a.length() == 0 && b.length() == 0)
            return "";
        int max=a.length();
        int i=a.length()-1, j=b.length()-1;
        StringBuilder str = new StringBuilder("");
        if(a.length() < b.length())
            max=b.length();
        int carry=0, valueB, valueA;
        for(int k=0; k<max; k++){
            if(j<0){
                valueB=0;
                valueA=Character.getNumericValue(a.charAt(i));
                i--;
            }
            else if(i<0){
                valueA=0;
                valueB=Character.getNumericValue(b.charAt(j));
                j--;
            }
            else{
                valueA=Character.getNumericValue(a.charAt(i));
                valueB=Character.getNumericValue(b.charAt(j));
                i--;
                j--;
            }
            if(valueA+valueB+carry == 2){
                str.append(0);
                carry=1;
            }
            else if(valueA+valueB+carry == 3){
                str.append(1);
                carry=1;
            }
            else{
                str.append(valueA+valueB+carry);
                carry=0;
            }
        }
        if(carry == 1)
            str.append(carry);
        return str.reverse().toString();
    }
}