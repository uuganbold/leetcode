import java.util.*;
class Solution202 {
    public boolean isHappy(int n) {
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