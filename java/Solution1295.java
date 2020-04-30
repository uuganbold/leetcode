class Solution1295 {
    
    public int numberOfDigit(int n){
        int count=0;
        while(n>0){
            count+=1;
            n/=10;
        }
        return count;
    }
    
    public int findNumbers(int[] nums) {
        int count=0;
        for(int num:nums){
            int dn=numberOfDigit(num);
            if(dn%2==0) count+=1;
        }
        return count;
    }
}