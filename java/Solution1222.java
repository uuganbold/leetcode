import java.util.*;
class Solution1222 {
    
    private final static int[][] DIRS={{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
    
    /*
        T: O(N)
        S: O(1)
    */
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> ans=new ArrayList<>();
        
        long board=0;
        
        for(int[] q:queens){
            board=board|(1L<<(8*q[0]+q[1]));
        }
    
        for(int[] dir:DIRS){
            int r=king[0], c=king[1];
            while(r>=0&&c>=0&&r<8&&c<8){
                 if((board&(1L<<(r*8+c)))!=0){
                     ans.add(List.of(r,c));
                     break;
                 }
                r+=dir[0];
                c+=dir[1];
            }
        }
        
        return ans;
    }
    
    
}