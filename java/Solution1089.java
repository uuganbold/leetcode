class Solution1089 {

    /*
        T: O(N)
        S: O(1)
    */
    public void duplicateZeros(int[] arr) {
        int numOfZero=0;
        int i=0;
        for(;i+numOfZero<arr.length;i++){
            if(arr[i]==0){
                numOfZero+=1;
            }
        }
        
        i--;
        
        for(;i>=0;i--){
            if(i+numOfZero<arr.length) arr[i+numOfZero]=arr[i];
            if(arr[i]==0) arr[i+(--numOfZero)]=0;
        }
        
        
    }
}