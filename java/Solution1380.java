import java.util.*;

class Solution1380 {

    /**
     * T: O(m*n)
     * S: O(m+n)
     */
    public List<Integer> luckyNumbers (int[][] matrix) {
        int[] rowMins=new int[matrix.length];
        Arrays.fill(rowMins,Integer.MAX_VALUE);
        int[] colMax=new int[matrix[0].length];
        Arrays.fill(colMax,Integer.MIN_VALUE);
        
        
        for(int r=0;r<matrix.length;r++){
            for(int c=0;c<matrix[r].length;c++){
                if(matrix[r][c]<rowMins[r]) rowMins[r]=matrix[r][c];
                if(matrix[r][c]>colMax[c]) colMax[c]=matrix[r][c];
            }
        }
        
        List<Integer> result=new ArrayList<>();
        for(int r=0;r<matrix.length;r++){
            for(int c=0;c<matrix[r].length;c++){
                if(matrix[r][c]==rowMins[r]&&matrix[r][c]==colMax[c]) result.add(matrix[r][c]);
            }
        }
        
        return result;
    }
}