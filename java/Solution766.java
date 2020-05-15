class Solution766 {
    
    /*
        T: O(N)
        S: O(1)
    */
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int r=1;r<matrix.length;r++){
            for(int c=1;c<matrix[r].length;c++){
                if(matrix[r][c]!=matrix[r-1][c-1]) return false;
            }
        }
        
        return true;
    }
}