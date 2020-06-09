import java.util.*;
    class Solution {
        /*
            T: O(max(A,logK))
            S: O(max(A,logK))
        */
        public List<Integer> addToArrayForm(int[] A, int K) {
            LinkedList<Integer> ans=new LinkedList<>();
            int mem=0;
            int j=A.length-1;
            while(K>0||j>=0){
                int digit=mem;
                if(j>=0){
                    digit+=A[j--];
                }
                if(K>0){
                    digit+=K%10;
                    K/=10;
                }
                ans.addFirst(digit%10);
                mem=digit/10;
            }
            
            if(mem!=0){
                ans.addFirst(mem);
            }
            
            return ans;
        }
    }