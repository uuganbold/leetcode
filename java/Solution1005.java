import java.util.*;
class Solution1005 {
    
    /*
        T: O(NlogN+KlogN)
        S: O(N)
    */
    public int largestSumAfterKNegations(int[] A, int K){
        if(A==null||A.length==0) return 0;
        
        PriorityQueue<Integer> minHeap=new PriorityQueue<>(A.length);
        
        for(int a:A){
            minHeap.add(a);
        }
        
        while(K>0){
            int x=minHeap.poll();
            minHeap.add(-1*x);
            K--;
        }
        int sum=0;
        for(int x:minHeap){
            sum+=x;
        }
        
        return sum;
    }
    
    /*
        T: O(NlogN+KN)
        S: O(1)
    */
    public int largestSumAfterKNegationsSort(int[] A, int K) {
        if(A==null||A.length==0) return 0;
        
        int sum=0;
        Arrays.sort(A);
        while(K>0){
            A[0]=-1*A[0];
            insertFirstInPosition(A);
            K--;
        }
        
        for(int i:A){
            sum+=i;
        }
        
        return sum;
    }
    
    private void insertFirstInPosition(int[] A){
        int first=A[0];
        int i=1;
        for(;i<A.length;i++){
            if(A[i]>=first) break;
            A[i-1]=A[i];
        }
        A[i-1]=first;
    }
}