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
class Solution1382 {

    /*
        T: O(N)
        S: O(N)
    */
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sorted=new ArrayList<>();
        
        dfsMorris(root,sorted);
        return constructBST(sorted,0,sorted.size());
    }
    
    private TreeNode constructBST(List<Integer> sorted, int left, int right){
        if(left==right){
            return null;
        }
        int mi=left+(right-left)/2;
        TreeNode root=new TreeNode(sorted.get(mi));
        root.left=constructBST(sorted,left,mi);
        root.right=constructBST(sorted,mi+1,right);
        return root;
    }
    
    private void dfsMorris(TreeNode root, List<Integer> ans){
        
        while(root!=null){
            
            if(root.left!=null){
                
                TreeNode node=root.left;
                while(node.right!=null&&node.right!=root){
                    node=node.right;
                }
                
                if(node.right==null){
                    node.right=root;
                    root=root.left;
                }else{
                    ans.add(root.val);
                    root=root.right;
                }
                
            }else{
                ans.add(root.val);
                root=root.right;
            }
            
        }
        
    }
    
    private void dfsStack(TreeNode root, List<Integer> ans){
        
        Stack<TreeNode> stack=new Stack<>();
        while(root!=null||!stack.isEmpty()){
            
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            
            root=stack.pop();
            ans.add(root.val);
            root=root.right;
        }
    }
    
    private void dfs(TreeNode root, List<Integer> ans){
        if(root==null){
            return ;
        }
        
        dfs(root.left,ans);
        ans.add(root.val);
        dfs(root.right,ans);
    }
}