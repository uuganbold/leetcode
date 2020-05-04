import java.util.*;
class Solution728 {

    /**
     * T: O(n) - n-number of digits.
     * S: O(1)
     */
    public List<Integer> selfDividingNumbers(int left, int right) {
         List<Integer> result=new ArrayList<>();
        for(int i=left;i<=right;i++){
            int number=i;
            while(number>0){
                int digit=number%10;
                if(digit==0||i%digit!=0) break;
                number=number/10;
            }
            if(number==0) result.add(i);
        }
        return result;
    }
}