class Solution1508 {
    /*
        T: O(n^2)
        S: O(N^2)
    */
    public int rangeSum(int[] nums, int n, int left, int right) {
        int size=n*(n+1)/2;
        int[] arr=new int[size];
        
        int k=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
               sum+=nums[j];
               arr[k++]=sum;
            }
        }
        
        
        Arrays.sort(arr);
        int ans=0;
        int mod=1_000_000_007;
        for(int i=left-1;i<right;i++){
            ans=(ans+arr[i])%mod;
        }
        
        return ans;
    }

}
