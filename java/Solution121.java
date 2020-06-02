class Solution121 {
    
    /*
        T: O(N)
        S: O(1)
    */
    public int maxProfit(int[] prices){
        int minprice=Integer.MAX_VALUE;
        int maxprofit=0;
        for(int price:prices){
            if(price<minprice){
                minprice=price;
            }else if(price-minprice>maxprofit){
                maxprofit=price-minprice;
            }
        }
        
        return maxprofit;
        
    }
    public int maxProfitRecurse(int[] prices) {
        return maxProfitHelper(prices,0,prices.length);
    }
    
    /*
        T: O(NlogN)
        S: O(logN)
    */
    private int maxProfitHelper(int[] prices, int start, int end){
        if(start+1>=end){
            return 0;
        }
        int mid=(start+end)/2;
        int left=maxProfitHelper(prices,start,mid);
        int right=maxProfitHelper(prices,mid,end);
        
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        
        for(int i=start;i<mid;i++){
            if(prices[i]<min) min=prices[i];
        }
        
        for(int i=mid;i<end;i++){
            if(prices[i]>max) max=prices[i];
        }
        
        return Math.max(Math.max(left,right),max-min);
    }
}