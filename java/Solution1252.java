class Solution1252 {
    
    private int evenNumber(int[] arr){
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==0) count++;
        }
        return count;
    }

    /**
     * T: O(max(n,m,indices.length))
     * S: O(n+m)
     */
    public int oddCells(int n, int m, int[][] indices) {
        int[] rows=new int[n];
        int[] cols=new int[m];
        
        for(int[] index:indices){
            rows[index[0]]++;
            cols[index[1]]++;
        }
        
        int reven=evenNumber(rows), rodd=n-reven;
        int ceven=evenNumber(cols), codd=m-ceven;
        
        return reven*codd+rodd*ceven;
        
    }
}