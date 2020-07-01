import java.util.*;

class Solution797 {
    int[][] graph;
    List<List<Integer>> ans;
    
    /*
        T: O(N)
        S: O(N)
    */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph=graph;
        this.ans=new ArrayList<>();
        
        ArrayList<Integer> path=new ArrayList<>();
        dfsRecurse(0,graph.length-1,path);
        
        return ans;
    }
   
    private void dfsRecurse(int root, int target, ArrayList<Integer> path){
         path.add(root);
         if(root==target){
             ans.add((ArrayList)path.clone());
         }else{
            for(int child:graph[root]){
                dfsRecurse(child,target,path);
            } 
         }
         path.remove(path.size()-1);
         
    }
    
    
}