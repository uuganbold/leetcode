class Solution661 {

    /*
        T: O(N)
        S: O(N)
    */
    public int[][] imageSmoother(int[][] M) {
        int[][] ans=new int[M.length][M[0].length];
        
        for(int i=0;i<M.length;i++){
            for(int j=0;j<M[i].length;j++){
                
                int sum=0;
                int count=0;
                for(int r=-1;r<=1;r++){
                    for(int c=-1;c<=1;c++){
                        if(i+r>=0&&i+r<M.length&&j+c>=0&&j+c<M[i].length){
                            sum+=M[i+r][j+c];
                            count++;
                        }
                    }
                }
            
                
                ans[i][j]=sum/count;
                
                
            }
        }
        
        return ans;
    }
    
}