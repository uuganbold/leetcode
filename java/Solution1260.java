import java.util.*;

class Solution1260 {
    /*
        T: O(N)
        S: O(1)
    */
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int size=grid.length*grid[0].length;
        k=k%size;
        
        int begin=size-k;
        int c=begin%grid[0].length;
        int r=((begin-c)/grid[0].length)%grid.length;
        
        List<List<Integer>> ans=new ArrayList<>();

        for(int i=0;i<grid.length;i++){
            List<Integer> row=new ArrayList<>();
            for(int j=0;j<grid[0].length;j++){
                row.add(grid[r][c]);
                c++;
                if(c==grid[0].length) {
                    c=0;
                    r++;
                    if(r==grid.length) r=0;
                }
            }
            ans.add(row);
        }
        
        return ans;
    }
}