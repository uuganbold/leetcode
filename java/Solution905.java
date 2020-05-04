import java.util.*;
class Solution905 {

    /**
     * T: O(N)
     * S: O(1)
     */
    public int[] sortArrayByParityBetter(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 > A[j] % 2) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }

            if (A[i] % 2 == 0) i++;
            if (A[j] % 2 == 1) j--;
        }

        return A;
    }

    public int[] sortArrayByParity(int[] A) {
        int left=0;
        int right=A.length-1;
        while(left<right){
            while(left<A.length&&A[left]%2==0) left++;
            while(right>=0&&A[right]%2==1) right--;
            if(left<right){
                int temp=A[left];
                A[left]=A[right];
                A[right]=temp;
            }
            
        }
        return A;
    }

    /**
     * T: O(NlogN)
     * S: O(N)
     */
    public int[] sortArrayByParityStream(int[] A) {
        return Arrays.stream(A)
                     .boxed()
                     .sorted((a, b) -> Integer.compare(a%2, b%2))
                     .mapToInt(i -> i)
                     .toArray();
    }
}