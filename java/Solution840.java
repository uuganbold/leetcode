class Solution840 {

    /*
        T: O(R*C)
        S: O(1)
    */
    public int numMagicSquaresInside(int[][] grid) {
         int count=0;
         for(int i=0;i<grid.length-2;i++){
             for(int j=0;j<grid[0].length-2;j++){
                 if(isMagicSquare(grid,i,j)){
                     count++;
                 }
             }
         }
        
        return count;
    }
    
    private boolean isMagicSquare(int[][] grid, int r, int c){
        int[] digits=new int[9];
        
        for(int i=r;i<r+3;i++){
            for(int j=c;j<c+3;j++){
                if(grid[i][j]<=0||grid[i][j]>=10){
                    return false;
                }
                if(digits[grid[i][j]-1]==1){
                    return false;
                }else{
                    digits[grid[i][j]-1]=1;
                }
            }
        }
        
        return (grid[r][c]+grid[r][c+1]+grid[r][c+2]==15&&
               grid[r+1][c]+grid[r+1][c+1]+grid[r+1][c+2]==15&&
               grid[r+2][c]+grid[r+2][c+1]+grid[r+2][c+2]==15&&
               grid[r][c]+grid[r+1][c]+grid[r+2][c]==15&&
               grid[r][c+1]+grid[r+1][c+1]+grid[r+2][c+1]==15&&
               grid[r][c+2]+grid[r+1][c+2]+grid[r+2][c+2]==15&&
               grid[r][c]+grid[r+1][c+1]+grid[r+2][c+2]==15&&
               grid[r][c+2]+grid[r+1][c+1]+grid[r+2][c]==15);
        
    }
    
    
}