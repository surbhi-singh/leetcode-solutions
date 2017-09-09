class Solution {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE, result=0;
        for(int i=0; i<prices.length; i++){
            if(prices[i]<min){
                min = prices[i];
            }
            else if(result < (prices[i]-min)){
                result = prices[i]-min;
            }
        }
        return result;

    }
}