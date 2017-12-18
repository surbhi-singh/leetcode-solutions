class Solution {
    public boolean isHappy(int n) {
        if(n <= 0) {
            return false;
        }
        else {
            int sum=0, flag=0;
            Set<Integer> set = new HashSet<>();
            set.add(n);
            while(n > 0) {
                sum = sum+ (int)Math.pow(n%10, 2);
                n /= 10;
                if(n == 0) {
                    if(sum == 1) {
                        flag=1;
                        break;
                    }
                    else if(set.contains(sum)) {
                        break;
                    }
                    else {
                        set.add(sum);
                        n = sum;
                        sum = 0;
                    }
                }
            }
            if(flag == 1) return true;
            else return false;
        }
    }
}
