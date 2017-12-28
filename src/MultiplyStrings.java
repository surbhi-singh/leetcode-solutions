class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) {
            return new StringBuilder("0").toString();
        }
        else {
            int maxLength = Math.max(num1.length(), num2.length());
            StringBuilder mulresult = new StringBuilder("");
            StringBuilder temp = new StringBuilder();
            for(int i=num1.length()-1, count=0; i>=0; i--, count++) {
                for(int j=num2.length()-1, carry=0; j>=0; j--) {
                    int mul = Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j)) + carry;
                    carry = mul / 10;
                    if(mul > 9) {
                        mul = mul % 10;
                    }
                    temp.insert(0, mul);
                    if(j == 0 && carry != 0) {
                    temp.insert(0, carry);
                }
                }
                int num = count;
                if(num == 0) {
                    mulresult = new StringBuilder(temp);
                    temp.delete(0, temp.length());
                    continue;
                }
                while(num-- > 0) {
                    temp.append("0");
                }
                int carry=0, lentemp, lenres;
                for(lentemp=temp.length()-1, lenres=mulresult.length()-1; lentemp>=0 && lenres>=0; lentemp--, lenres--) {
                    int t = Character.getNumericValue(temp.charAt(lentemp)) + Character.getNumericValue(mulresult.charAt(lenres)) + carry;
                    carry = t/10;
                    if(t > 9) {
                        t%=10;
                    }
                    String emp = t+"";
                    mulresult.setCharAt(lenres, emp.charAt(0));
                }
                while(lentemp >= 0) {
                    int t = carry + Character.getNumericValue(temp.charAt(lentemp));
                    carry = t/10;
                    if(t > 9) {
                        t%=10;
                    }
                    mulresult.insert(0, t);
                    lentemp--;
                }
                if(carry != 0) {
                    mulresult.insert(0, carry);
                }
                temp.delete(0, temp.length());
            }
            return mulresult.toString();
        }
    }
}
