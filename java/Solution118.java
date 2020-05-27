import java.util.*;
class Solution118 {

    /*
        T: O(N^2)
        S: O(1)
    */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>(numRows);
        if(numRows==0) return ans;
        
        List<Integer> firstRow=new ArrayList<>();
        firstRow.add(1);
        ans.add(firstRow);
        
        for(int i=2;i<=numRows;i++){
            List<Integer> row=new ArrayList<>(i);
            
            row.add(1);
            
            List<Integer> prevRow=ans.get(i-2);
            for(int j=1;j<i-1;j++){
                row.add(prevRow.get(j-1)+prevRow.get(j));
            }
            
            row.add(1);
            
            ans.add(row);
        }
        
        return ans;
    }
    
    
}