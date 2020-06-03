import java.util.*;
class Solution455 {
    
    /*
        T: O(GlogG+SlogS)
        S: O(G+S)
    */
    public int findContentChildren(int[] g, int[] s){
        PriorityQueue<Integer> children=new PriorityQueue<>();
        PriorityQueue<Integer> cookies=new PriorityQueue<>();
        
        for(int n:g){
            children.offer(n);
        }
        
        for(int n:s){
            cookies.offer(n);
        }
        
        int count=0;
        while(!children.isEmpty()&&!cookies.isEmpty()){
             if(children.peek()<=cookies.poll()){
                 children.poll();
                 count++;
             }
        }
        
        return count;
    }
    
    /*
        T: O(GLogG+SLogS)
        S: O(1)
    */
    public int findContentChildrenSort(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int count=0;
        
        int i=0, j=0;
        while(i<g.length&&j<s.length){
            if(g[i]<=s[j]){
                i++;
                j++;
            }else{
                j++;
            }
        }
        
        return i;
    }
}