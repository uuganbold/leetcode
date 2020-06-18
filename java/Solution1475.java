class Solution1475 {

    /*
        T: O(N^2)
        S: O(1)
    */
    public int[] finalPrices(int[] prices) {
         int[] ans=new int[prices.length];
         for(int i=0;i<prices.length;i++){
             int smaller=0;
             for(int j=i+1;j<prices.length;j++){
                 if(prices[j]<=prices[i]){
                     smaller=prices[j];
                     break;
                 }
             }
             ans[i]=prices[i]-smaller;
         }
        
        return ans;
    }
}