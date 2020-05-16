import java.util.*;
class Solution1046 {

    /*
        T: O(nlogn)
        S: O(N)
    */
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(stones.length,Collections.reverseOrder());
        
        for(int s:stones){
            pq.offer(s);
        }
        
        while(pq.size()>1){
            int first=pq.poll();
            int second=pq.poll();
            
            if(first!=second){
                pq.offer(first-second);
            }
        }
        
        return pq.size()>0?pq.poll():0;
    }
}