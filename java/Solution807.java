class Solution807 {

    /*
        T: O(2N^2)
        S: O(N)
    */
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] rowMax=new int[grid.length]; 
        int[] colMax=new int[grid[0].length];
        
        int ans=0;
        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(grid[r][c]>rowMax[r]){
                    rowMax[r]=grid[r][c];
                }
                if(grid[r][c]>colMax[c]){
                    colMax[c]=grid[r][c];
                }
            }
        }
        
        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                ans+=Math.min(rowMax[r],colMax[c])-grid[r][c];
            }
        }
        
        return ans;
    }
}