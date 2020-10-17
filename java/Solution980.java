class Solution980 {
    
    private final static int START=1;
    private final static int OBSTACLE=-1;
    private final static int END=2;
    private final static int EMPTY=0;
    
    private int N;
    private int M;
    public int uniquePathsIII(int[][] grid) {
        N=grid.length;
        M=grid[0].length;
        
        int r=-1;
        int c=-1;
        int obstacles=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(grid[i][j]==START){
                    r=i;
                    c=j;
                }else if(grid[i][j]==OBSTACLE){
                    obstacles++;
                }
            }
        }
        
        return backtrack(grid,r,c,N*M-1-obstacles);
    }
    
    private int backtrack(int[][] grid, int r, int c, int moves){
        if(grid[r][c]==OBSTACLE){
            return 0;
        }
        if(grid[r][c]==END){
            if(moves==0){
                return 1;
            }else{
                return 0;
            }
        }
        
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        int ans=0;
        grid[r][c]=OBSTACLE;
        
        for(int[] dir:dirs){
            int x=r+dir[0];
            int y=c+dir[1];
            if(x>=0&&x<N&&y>=0&&y<M){
                ans+=backtrack(grid,x,y,moves-1);
            }
        }
        
        grid[r][c]=EMPTY;
        
        return ans;
        
    }
}