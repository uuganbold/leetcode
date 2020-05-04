import java.util.*;

class Solution977 {

    /**
     * T:O(NlogN) - for sorting
     * S:O(N) because of timsort
     */
    public int[] sortedSquaresStream(int[] A) {
        int[] result=Arrays.stream(A).map(i->i*i).toArray();
        Arrays.sort(result);
        return result;
    }
    
    /**
     * T: O(NlogN) - for sorting
     * S: O(N) - because of Timsort
     */
    public int[] sortedSquaresSimple(int[] A){
         for(int i=0;i<A.length;i++){
             A[i]=A[i]*A[i];
         }
        Arrays.sort(A);
        return A;
    }
    
    /**
     * T : O(N)
     * S: O(1) - does not use additional storage except result value.
     */
    public int[] sortedSquares(int[] A){
        int[] result=new int[A.length];
        
        int firstPositive=findFirstPositive(A);
        int left=firstPositive-1;
        int right=firstPositive;
        
        int r=0;
        while(left>=0&&right<A.length){
            if(0-A[left]>=A[right]) {result[r++]=A[right]*A[right]; right++;}
            else {result[r++]=A[left]*A[left]; left--;}
        }
        
        while(left>=0){
            result[r++]=A[left]*A[left]; left--;
        }
        
        while(right<A.length){
            result[r++]=A[right]*A[right]; right++;
        }
        
        return result;
    }
    
    private int findFirstPositive(int[] A){
        int left=0;
        int right=A.length;
        while(left<right){
            int mid=(left+right)/2;
            if(A[mid]<0) left=mid+1;
            if(A[mid]>=0) right=mid;
        }
        return left;
    }
}