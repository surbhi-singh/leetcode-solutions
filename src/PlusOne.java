class Solution {
    public int[] plusOne(int[] digits) {
        int carry=1;
        ArrayList<Integer> arr = new ArrayList();
        if(digits.length == 0){
            return digits;
        }
        for(int i=digits.length-1; i>=0; i--){
            int temp = digits[i]+carry;
            if(temp/10 > 0){
                arr.add(temp%10);
                carry = temp/10;
            }
            else{
                arr.add(temp);
                carry=0;
            }
        }
        if(carry != 0)
            arr.add(carry);
        Collections.reverse(arr);
        int[] res = new int[arr.size()];
        for(int j=0; j<arr.size(); j++){
            res[j] = arr.get(j);
        }
        return res;
    }
}