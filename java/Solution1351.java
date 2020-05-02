class Solution1351 {
    /*
    T: O(n*m)
    S: O(1)
    */
    public int countNegatives(int[][] grid) {
        int c=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]<0) c++;
            }
        }
        return c;
    }


    /*
    T: O(m*logn)
    S: O(1)
    */
    public int countNegativesBinarySearch(int[][] grid) {
        int r=0;
        int c=grid[0].length;
        int count=0;
        while(r<grid.length){
            int n=findFirstNegative(grid[r],c);
            count+=(c-n)*(grid.length-r);
            r+=1;
            c=n;
        }
        return count;
    }
    
    private int findFirstNegative(int[] array, int end){
        int left=0;
        int right=end;
        while(left<right){
            int mid=(left+right)/2;
            if(array[mid]>=0) left=mid+1;
            else right=mid;
        }
        return left;
    }
}