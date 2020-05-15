class Solution1399 {

    /*
        T: O(N)
        S: O(1)
    */
    public int countLargestGroup(int n) {
        int[] digitSumCount=new int[36];
        
        for(int i=1;i<=n;i++){
             digitSumCount[sumOfDigit(i)-1]++;
        }
        
        int max=0;
        int count=0;
        for(int sumCount: digitSumCount){
            if(sumCount>max){
                count=1;
                max=sumCount;
            }else if(sumCount==max){
                count++;
            }
        }
        
        return count;
    }
    
    private int sumOfDigit(int n){
        int sum=0;
        while(n>0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
}