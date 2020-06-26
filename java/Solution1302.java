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
class Solution1302 {

    /*
        T: O(N)
        S: O(N)
    */
    public int deepestLeavesSum(TreeNode root) {
        dfs(root,0);
        return sum;
    }
    
    int maxLevel=0;
    int sum=0;
    private void dfs(TreeNode root, int level){
         if(root==null){
             return;
         }
        
         if(root.left==null&&root.right==null){
             if(level==maxLevel){
                 sum+=root.val;
             }else if(level>maxLevel){
                 sum=root.val;
                 maxLevel=level;
             }
         }else{
             dfs(root.left,level+1);
             dfs(root.right,level+1);
         }
    }
    
    private int bfs(TreeNode root){
         if(root==null){
             return 0;
         }
        
        Queue<TreeNode> queue=new LinkedList<>();
        int sum=0;
        queue.offer(root);
        
        while(!queue.isEmpty()){
            sum=0;
            Queue<TreeNode> level=new LinkedList<>();
            while(!queue.isEmpty()){
                TreeNode node=queue.poll();
                sum+=node.val;
                
                if(node.left!=null){
                    level.offer(node.left);
                }
                
                if(node.right!=null){
                    level.offer(node.right);
                }
            }
            
            queue=level;
            
        }
        
        return sum;
    }
}