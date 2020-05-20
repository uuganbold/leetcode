class Solution892 {

    /*
        T: O(N^2)
        S: O(1)
    */
    public int surfaceArea(int[][] grid) {
        int surface=0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                
                int height=grid[i][j];
                
                if(height!=0){
                   surface+=2; // top and bottom
                
                    if(j-1<0||grid[i][j-1]==0){
                        surface+=height;
                    }else{
                        surface+=-grid[i][j-1]+Math.abs(height-grid[i][j-1]);
                    }

                    if(i-1<0||grid[i-1][j]==0){
                        surface+=height;
                    }else{
                        surface+=-grid[i-1][j]+Math.abs(height-grid[i-1][j]);
                    }

                    surface+=2*height; 
                }
                             
            }
        }
        
        return surface;
    }
}