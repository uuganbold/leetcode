import java.util.*;
class Solution950 {

    /*
        T: O(NLogN)
        S: O(N)
    */
    public int[] deckRevealedIncreasing(int[] deck) {
        
        Arrays.sort(deck);
        
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<deck.length;i++){
            queue.offer(i);
        }
        
        int[] ans=new int[deck.length];
        
        for(int i=0;i<deck.length;i++){
            ans[queue.poll()]=deck[i];
            if(!queue.isEmpty()){
                queue.offer(queue.poll());
            }
            
        }
        
        return ans;
    }
}