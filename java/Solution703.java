import java.util.*;
public class Solution703 {
    class KthLargestPQ {
    
        PriorityQueue<Integer> pq;
        int maxSize;
        
        /*
            T: O(k)
            S: O(k)
        */
        public KthLargestPQ(int k, int[] nums) {
            maxSize=k;
            pq=new PriorityQueue<>(maxSize);
            for(int n:nums){
                this.add(n);
            }
        }
        
        /*
            T: O(logK)
            S: O(1)
        */
        public int add(int val) {
            if(pq.size()<maxSize){
                pq.offer(val);
            }else{
                if(val>pq.peek()){
                    pq.poll();
                    pq.offer(val);
                }
            }     
            return pq.peek(); 
        }
    }

    class KthLargest {
    
        private int[] heap;
        private int heapSize;
        
        /*
            T: O(k)
            S: O(k)
        */
        public KthLargest(int k, int[] nums) {
            heapSize=0;
            heap=new int[k];
            for(int n:nums){
                this.add(n);
            }
        }
        
        private int left(int i){
            return i*2+1;
        }
        
        private int right(int i){
            return i*2+2;
        }
        
        private int parent(int i){
            return (i-1)/2;
        }
        
        /*
            T: O(logK)
        */
        private void minHeapify(int i){
            int smallest=i;
            while(true){
                int l=left(i);
                int r=right(i);
                if(l<heapSize&&heap[smallest]>heap[l]){
                    smallest=l;
                }
                if(r<heapSize&&heap[smallest]>heap[r]){
                    smallest=r;
                }
                if(smallest!=i){
                    exchange(i,smallest);
                    i=smallest;
                }else break;            
            }
        }
        
        /*
            T: O(logK)
        */
        private void insert(int val){
            heap[heapSize]=val;
            int i=heapSize;
            int p=parent(i);
            while(i>0&&heap[p]>heap[i]){
                exchange(p,i);
                i=p;
                p=parent(i);
            }    
            heapSize++;
        }
        
        private int min(){
            return heap[0];
        }
        
        private void exchange(int i, int j){
            int temp=heap[i];
            heap[i]=heap[j];
            heap[j]=temp;
        }
        
        /*
            T: O(logK)
        */
        public int add(int val) {
            if(heapSize<heap.length){
                insert(val);
            }else{
                if(val>min()){
                    heap[0]=val;
                    minHeapify(0);
                }
            }     
            return min();  
        }
    }
    
    /**
     * Your KthLargest object will be instantiated and called as such:
     * KthLargest obj = new KthLargest(k, nums);
     * int param_1 = obj.add(val);
     */
}