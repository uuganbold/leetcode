import java.util.*;
public class Solution1476 {
    class SubrectangleQueries {

        int[][] rectangle;
        List<int[]> updates;
        public SubrectangleQueries(int[][] rectangle) {
            this.rectangle=rectangle;
            updates=new ArrayList<>();
        }
        
        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            updates.add(new int[]{row1,col1,row2,col2,newValue});
        }
        
        public int getValue(int row, int col) {
            for(int i=updates.size()-1;i>=0;i--){
                int[] up=updates.get(i);
                if(up[0]<=row&&up[2]>=row&&up[1]<=col&&up[3]>=col){
                    return up[4];
                }
            }
            return rectangle[row][col];
        }
    }
    
    /**
     * Your SubrectangleQueries object will be instantiated and called as such:
     * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
     * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
     * int param_2 = obj.getValue(row,col);
     */
}