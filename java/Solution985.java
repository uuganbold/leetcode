class Solution985 {

    /*
        T: O(A.length+queries.length);
        S: O(1)
    */
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sumOfEven=0;
        for(int i=0;i<A.length;i++){
            if(A[i]%2==0) sumOfEven+=A[i];
        }
    
        int[] ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            
            int[] q=queries[i];
            
            if(A[q[1]]%2==0) sumOfEven-=A[q[1]];
            A[q[1]]+=q[0];
            
            if(A[q[1]]%2==0) sumOfEven+=A[q[1]];
            
            ans[i]=sumOfEven;
        }
        
        return ans;
    }
}