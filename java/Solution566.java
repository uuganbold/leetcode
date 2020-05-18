class Solution566 {

    /*
        T: O(r*n)
        S: O(1)
    */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(r*c!=nums.length*nums[0].length) return nums;
        
        int[][] ans=new int[r][c];
        
        int row=0;
        int col=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                ans[row][col]=nums[i][j];
                col++;
                if(col>=ans[0].length){
                    col=0;
                    row++;
                }
            }
        }
        
        return ans;
        
    }
}