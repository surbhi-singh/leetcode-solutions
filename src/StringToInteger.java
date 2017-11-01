class Solution {
    public int myAtoi(String str) {
        if(str.length() == 0 || str == null || str.trim().length() == 0) {
            return 0;
        }
        else {
            char[] charArr = str.trim().toCharArray();
            char sign = '+';
            int number=0;
            for(int i=0; i<charArr.length; i++) {
                if(i == 0) {
                    if(charArr[i] == '+')
                        continue;
                    else if(charArr[i] == '-') {
                        sign = '-';
                        continue;
                    }
                }
                if(Character.getNumericValue(charArr[i]) >= 0 && Character.getNumericValue(charArr[i]) <= 9) {
                    long temp = number * (long)10 + Character.getNumericValue(charArr[i]);
                    if(sign == '+' && temp > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                    else if(sign == '-' && (temp*-1) < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }

                    number = (int)temp;
                }
                else {
                    break;
                }
            }
            if(sign == '-')
                return number * -1;
            else
                return number;
        }

    }
}
