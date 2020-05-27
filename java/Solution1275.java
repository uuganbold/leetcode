class Solution1275 {

    /*
        T: O(1)
        S: O(1)
    */
    public String tictactoe(int[][] moves) {
        
        int[][] board=new int[3][3];
           
        int turn=1;
        for(int[] move:moves){
            board[move[0]][move[1]]=turn;
            turn=-1*turn;
        }
        
        
        for(int i=0;i<3;i++){
            int sum=0;
            int sumy=0;
            
            for(int j=0;j<3;j++){
                sum+=board[i][j];
                sumy+=board[j][i];
            }
            if(sum==3||sumy==3) return "A";
            else if(sum==-3||sumy==-3) return "B";
        }
        
        int sumd1=0;
        int sumd2=0;
        for(int i=0;i<3;i++){
            sumd1+=board[i][i];
            sumd2+=board[i][2-i];
        }
        
        if(sumd1==3||sumd2==3) return "A";
        else if(sumd1==-3||sumd2==-3) return "B";
        
        if(moves.length==9) return "Draw";
        
        return "Pending";
        
        
    }
}