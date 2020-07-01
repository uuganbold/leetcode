/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;
class Solution894 {
    
    Map<Integer,List<TreeNode>> dp=new HashMap<>();
    
    /*
        T: O(2^N)
        S: O(2^N)
    */
    public List<TreeNode> allPossibleFBT(int N) {
        
        if(!dp.containsKey(N)){
            List<TreeNode> ans=new ArrayList<>();
        
            if(N%2==0){
                return ans;
            }
            if(N==1){
                ans.add(new TreeNode(0));
                return ans;
            }
            for(int i=1;i<N;i+=2){
                List<TreeNode> left=allPossibleFBT(i);
                List<TreeNode> right=allPossibleFBT(N-i-1);
                for(TreeNode l:left){
                    for(TreeNode r:right){
                        TreeNode root=new TreeNode(0);
                        root.left=l;
                        root.right=r;
                        ans.add(root);
                    }
                }
            }

            dp.put(N,ans);
        }
        return dp.get(N);  
    }
    

    
}