import java.util.*;
class Solution1329 {

    /*
        T: O(M^2LogM+N^2logN)
        S: O(Min(n,m))
    */
    public int[][] diagonalSort(int[][] mat) {
        
        for(int i=0;i<mat.length;i++){
            sortWhenStart(mat, i,0);
        }
        
        for(int j=1;j<mat[0].length;j++){
            sortWhenStart(mat,0,j);
        }
        
        return mat;
    }


    private void sortWhenStart(int[][] mat, int r, int c){
        int length=Math.min(mat.length-r,mat[0].length-c);
        quickSort(mat, r, c, length);
    }
    
    private void quickSort(int[][] mat, int r, int c, int l){
        if(l>1){
            
            int p=partition(mat, r, c, l);
            
            quickSort(mat, r,c,p);
            quickSort(mat, r+p+1, c+p+1,l-p-1);
        }
    }
    
    private int partition(int[][] mat, int r, int c, int l){
        int pivot=mat[r+l-1][c+l-1];
        int small=-1;
        for(int great=0;great<l;great++){
            if(mat[r+great][c+great]<=pivot){
                small++;
                int temp=mat[r+small][c+small];
                mat[r+small][c+small]=mat[r+great][c+great];
                mat[r+great][c+great]=temp;
            }
        }
        
        return small;
    }
    
    private void sortWhenStartLang(int[][] mat, int r, int c){
        int length=Math.min(mat.length-r,mat[0].length-c);
        int[] arr=new int[length];
        for(int i=0;i<length;i++){
            arr[i]=mat[r+i][c+i];
        }
        Arrays.sort(arr);
        for(int i=0;i<length;i++){
            mat[r+i][c+i]=arr[i];
        }
    }
}