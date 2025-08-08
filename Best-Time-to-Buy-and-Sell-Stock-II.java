class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        int profit = 0;
        int n = prices.length;
        for(int i=0;i<n;i++){
            if(prices[i]<minPrice){
                minPrice = prices[i];
            }else if(prices[i]-minPrice>maxProfit){
                profit += prices[i]-minPrice;
                minPrice = prices[i];
            }
        }
        return profit;
    }
}