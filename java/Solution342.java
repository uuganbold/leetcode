class Solution342 {
    

    /*
        T: O(LogLogN)
        S: O(1)
    */
    public boolean isPowerOfFour(int num) {
        if(num<=0) return false;
        int i = num & (num-1);
        int digit = (int)(Math.log(num)/Math.log(2));
        return i==0 && digit%2==0;
    }

    /*
        T: O(LogN)
        S: O(1)
    */
    public boolean isPowerOfFourLoop(int num){
        if(num<=0){
            return false;
        }
        while((num&3)==0){
            num=num>>2;
        }
        
        return num==1;
    }
    
    /*
        T: O(logN)
        S: O(logN)
    */
    public boolean isPowerOfFourRegex(int num) {
        String binaryStr=Integer.toBinaryString(num);
        return binaryStr.matches("^1(00)*$");
    }
    
    
}