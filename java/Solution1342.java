class Solution1342 {
    public int numberOfSteps (int num) {
        /*
           T:O(1)
           S:O(1)
        */
        int i=0;
        while(num>0){
            if((num&1)==1) {i+=2;}
            else i+=1;
            num=num>>1;
        }
        return i-1;
    }
}