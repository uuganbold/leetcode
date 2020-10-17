class Solution1605 {
    
    private int[][] sortedSum(int[] sum){
        int N=sum.length;
        int[][] sortedSum=new int[N][2];
        
        for(int i=0;i<N;i++){
            sortedSum[i][0]=i;
            sortedSum[i][1]=sum[i];
        }
        Arrays.sort(sortedSum,(a,b)->{
            return a[1]-b[1];
        });
        
        return sortedSum;
    }
    
    /*
        T: O(N^M)
        S: O(1)
    */
    public int[][] restoreMatrix(int[] row, int[] col) {
        int m = row.length, n = col.length;
        int[][] A = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0 ; j < n; ++j) {
                A[i][j] = Math.min(row[i], col[j]);
                row[i] -= A[i][j];
                col[j] -= A[i][j];
            }
        }
        return A;
    }
    
    /*
    
        T: O(NlogN+MlogM)
        S: O(N+M)
    */
    public int[][] restoreMatrix1(int[] rowSum, int[] colSum) {
        
        int N=rowSum.length;
        int M=colSum.length;
        
        
        int[][] sortedRowSum=sortedSum(rowSum);
        int[][] sortedColSum=sortedSum(colSum);
        
        int i=0;
        int j=0;
        
        int[][] ans=new int[N][M];
        while(i<N&&j<M){
            int val=Math.min(sortedRowSum[i][1],sortedColSum[j][1]);
            int x=sortedRowSum[i][0];
            int y=sortedColSum[j][0];
            
            ans[x][y]=val;
            
            sortedRowSum[i][1]-=val;
            if(sortedRowSum[i][1]==0) i++;
            
            sortedColSum[j][1]-=val;
            if(sortedColSum[j][1]==0) j++;
        }
        
        return ans;
        
        /*
        0  5 0 [5,
        6  1 0  7,
        2  0 0 10]        
        [8,6,8]
        
        
        0-1 9-0   
        0-0  0-2  9-1
        
        0 9 5
        6 0 3
        
        */
        
    }
}