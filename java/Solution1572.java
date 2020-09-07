class Solution1572 {
    /*
        T: O(N)
        S: O(1)
    */
    public int diagonalSum(int[][] mat) {
        int N=mat.length;
        int sum=0;
        
        for(int i=0;i<mat.length;i++){
            sum+=mat[i][i]+mat[i][N-i-1];
        }  
        
        if(N%2==1){
            sum-=mat[N/2][N/2];
        }
        
        return sum;
    }
}