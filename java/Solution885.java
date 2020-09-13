class Solution885 {
    
    private int R;
    private int C;
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        // 1,1,2,2,3,3,4,4,5,5,6,6,
        
        // 1-1, 2-1 3-2 4-2 5-3 6-3
        this.R=R;
        this.C=C;
        int[][] ans=new int[R*C][2];
        
        int count=0;
        int move=1;
        int rotateCount=1;
        
        int[] currPos={r0, c0};
        int[] currDir=nextDir(null);
        while(count<R*C){
            if(isValid(currPos)){
                ans[count][0]=currPos[0];
                ans[count][1]=currPos[1];
                count++;
            }
            
            if(move==0){
                currDir=nextDir(currDir);
                rotateCount++;
                move=(rotateCount+1)/2;
            }
            currPos=move(currPos,currDir);
            move--;  
        }
               
        return ans;
    }
               
    private int[] move(int[] pos, int[] dir){
        return new int[]{pos[0]+dir[0],pos[1]+dir[1]};
    }           
    
    private boolean isValid(int[] pos){
        return pos[0]>=0&&pos[0]<R&&pos[1]>=0&&pos[1]<C;
    }
               
    private int[] nextDir(int[] currDir){
        int[][] directions={
            {0,1},
            {1,0},
            {0,-1},
            {-1,0}
        };
        
        if(currDir==null){
            return directions[0].clone();
        }
        
        if(currDir[0]==0){
            if(currDir[1]==1){
                return directions[1].clone();
            }else{
                return directions[3].clone();
            }
        }else{
            if(currDir[0]==1){
                return directions[2].clone();
            }else{
                return directions[0].clone();
            }
        }
    }
}
