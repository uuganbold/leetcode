class Solution999 {

    /*
        T: O(N^2) - N size of board
        S: O(1)
    */
    public int numRookCaptures(char[][] board) {
        
         int i=0, j=0;
        
         findR:
         for(i=0;i<board.length;i++){
             for(j=0;j<board[i].length;j++){
                   if(board[i][j]=='R') break findR;
             }
         }
        
         int count=0;
         int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};
        
         for(int[] dir:dirs){
             int row=i;
             int col=j;
             
             while(true){
                 row=row+dir[0];
                 col=col+dir[1];
                 if(row<0||row>=board.length||col<0||col>=board.length) break;
                 if(board[row][col]=='p') {count++; break;}
                 if(board[row][col]=='B') { break;} 
             }
         }
        
        return count;
    }
}