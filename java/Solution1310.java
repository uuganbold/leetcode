class Solution1310 {

    /*
        T: O(N)
        S: O(N)
    */
    public int[] xorQueries(int[] arr, int[][] queries) {
        //[1,3,4,8]
        int N=arr.length;
        int[] xors=new int[N+1];
        for(int i=0;i<N;i++){
            xors[i+1]=xors[i]^arr[i];
        }
        
        int[] ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int start=queries[i][0];
            int end=queries[i][1];
            
            ans[i]=xors[start]^xors[end+1];
        }
        
        return ans;
    }
}