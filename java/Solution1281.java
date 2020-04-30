class Solution1281 {
    /*
    T:0(1)
    S:O(1)
    */
    public int subtractProductAndSum(int n) {
        int sum=0;
        int product=1;
        while(n>0){
            int digit=n%10;
            sum+=digit;
            product*=digit;
            n/=10;
        }
        return product-sum;
    }
}