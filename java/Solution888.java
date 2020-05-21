import java.util.*;

class Solution888 {

    /*
        T: O(A+B)
        S: O(B)
    */
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA=sum(A);
        int sumB=sum(B);
        
        Set<Integer> setB=arrayToSet(B);
        
        int fairAmount=(sumA+sumB)/2;
        int diffA=fairAmount-sumA;
        
        for(int a:A){
            if(setB.contains(a+diffA)) return new int[]{a,a+diffA};
        }
        
        throw null;
    }
    
    private Set<Integer> arrayToSet(int[] arr){
        Set<Integer> set=new HashSet<>();
        for(int i:arr) set.add(i);
        return set;
    }
    
    private int sum(int[] arr){
        int sum=0;
        for(int i:arr) sum+=i;
        return sum;
    }
}