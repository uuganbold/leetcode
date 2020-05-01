class Solution1223 {
    /*
    T: O(log(num))
    S: O(1)
    */
    public int maximum69Number (int num) {
        int p=1;
        int saved=num;
        while(num>p){
            int digit=(num%(10*p))/p;
            if(digit==6) saved=num+3*p;
            p=p*10;
        }
        
        return saved;
    }
}