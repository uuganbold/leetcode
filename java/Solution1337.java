import java.util.*;

class Solution1337 {
    /**
     * mat=mxn
     * T: O(m*log(n)+m*log(m))
     * S: O(m)
     */
    public int[] kWeakestRows(int[][] mat, int k) {

        int[][] sums=new int[mat.length][2];
        for(int i=0;i<mat.length;i++){
            int[] row=mat[i];
            int lo=0;
            int hi=row.length;
            
            while(lo<hi){
                int mi=(lo+hi)/2;
                
                if(row[mi]==0) hi=mi;
                else lo=mi+1;
            }
            
            sums[i][0]=i;
            sums[i][1]=lo;
        }
        
        Arrays.sort(sums,new Comparator<int[]>(){
            
            public int compare(int[] one, int[] other){
                int diff=one[1]-other[1];
                if(diff==0) return one[0]-other[0];
                else return diff;
            }
        });
        
        int[] result=new int[k];
        for(int i=0;i<k;i++){
            result[i]=sums[i][0];
        }
        
        return result;        
    }
}