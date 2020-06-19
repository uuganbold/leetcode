class Solution507 {

    /*
        T: O(sqrt(n))
        S: O(1)
    */
    public boolean checkPerfectNumber(int num) {
        if(num<=1){
            return false;
        }
        int sum=1;
        for(int i=2;i*i<=num;i++){
            if(num%i==0){
                int other=num/i;
                sum+=i;
                if(other!=i){
                    sum+=other;
                }
            }
        }
        return sum==num;
    }
}