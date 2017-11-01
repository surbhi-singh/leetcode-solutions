class Solution {
    public int reverse(int x) {
        if(x == 0)
            return x;
        else {
            char sign = '+';
            int num = x;
            long answer=0;
            if(x < 0) {
                sign = '-';
                num = x * -1;
            }
            while(num > 0) {
                answer = answer * (long)10 + num%10;
                num/=10;
                if(sign == '+' && answer > Integer.MAX_VALUE)
                    return 0;
                else if(sign == '-' && (answer*-1) < Integer.MIN_VALUE)
                    return 0;
            }
            return (sign == '-')?(int)answer*-1:(int)answer;
        }

    }
}
