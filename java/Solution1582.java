class Solution1582 {
    
    /*
        T: O(N*M)
        S: O(N+M)
     */
    public int numSpecial(int[][] mat){
        int N=mat.length;
        int M=mat[0].length;
        
        int[] rowSum=new int[N];
        int[] colSum=new int[M];
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                rowSum[i]+=mat[i][j];
                colSum[j]+=mat[i][j];
            }
        }
        
        int ans=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(mat[i][j]==1&&rowSum[i]==1&&colSum[j]==1){
                    ans++;
                }
            }
        }
        
        return ans;
    }
    
    public int numSpecial1(int[][] mat) {
        
        int N=mat.length;
        int M=mat[0].length;
        
        int[] rowSum=new int[N];
        int[] colSum=new int[M];
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                rowSum[i]+=mat[i][j];
                colSum[j]+=mat[i][j];
            }
        }
        
        int ans=0;
        for(int i=0;i<N;i++){
            if(rowSum[i]==1){
                for(int j=0;j<M;j++){
                    if(mat[i][j]==1){
                        if(colSum[j]==1){
                            ans++;
                        }
                        break;
                    }
                }
            }
        }
        
        return ans;
    }
}