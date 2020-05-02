class Solution1304 {
    /*
    T: O(n)
    S: O(1)
    */
    public int[] sumZero(int n) {
        int[] result=new int[n];
        for(int i=1;i<=n/2;i++){
            result[i-1]=i;
            result[n-i]=-1*i;
        }
        return result;
    }
}