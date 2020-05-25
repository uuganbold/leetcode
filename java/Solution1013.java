class Solution1013 {

    /*
        T:O(N)
        S:O(1)
    */
    public boolean canThreePartsEqualSum(int[] A) {
        int sum=0;
        for(int num:A){
            sum+=num;
        }
        
        if(sum%3!=0) return false;
        
        int target=sum/3;
        
        int count=0;
        sum=0;
        for(int num:A){
            sum+=num;
            if(sum==target){
                count++;
                sum=0;
            }
        }
        
        return count>=3;
    }
}