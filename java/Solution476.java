class Solution476 {

    /*
        T: O(1)
        S: O(1)
    */
    public int findComplement(int num) {
        int i=num;
        int mask=1;
        while(i>0){
            i=i>>1;
            mask=mask<<1;
        }
        return num^(mask-1);
    }
}