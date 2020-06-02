import java.util.*;
class Solution202 {

    public boolean isHappy(int n){
        while(n!=1){
            if(n==4) return false;
            n=sumOfSquareDigit(n);
        }
        
        return true;
    }


    public boolean isHappySet(int n) {
        Set<Integer> occurred=new HashSet<>();
        while(!occurred.contains(n)){
            occurred.add(n);
            n=sumOfSquareDigit(n);
        }
        return n==1;
    }
    
    private int sumOfSquareDigit(int n){
        int sum=0;
        while(n>0){
            int digit=n%10;
            sum+=digit*digit;
            n/=10;
        }
        return sum;
    }
}