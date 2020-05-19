class Solution1287 {

    /*
        T: O(N)
        S: O(1)
    */
    public int findSpecialInteger(int[] arr) {
        int quarter=arr.length/4;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]==arr[i+quarter]) return arr[i];
        }
        
        return -1;
    }
}