import java.util.*;
public class Solution933 {

        Queue<Integer> queue;
        
        public Solution933() {
            queue=new LinkedList<>();
        }
        
        /*
            T: O(N)
            S: O(N or 3000)
        */
        public int ping(int t) {
            queue.add(t);
            while (queue.peek() < t - 3000)
                queue.poll();
            return queue.size();
        }
    /**
     * Your RecentCounter object will be instantiated and called as such:
     * RecentCounter obj = new RecentCounter();
     * int param_1 = obj.ping(t);
     */
    
}