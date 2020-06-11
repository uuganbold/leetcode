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
class Solution501 {
    Map<Integer,Integer> counter=new HashMap<>();
    
    List<Integer> ans;
    int max=0;
    int prev=0;
    int count=0;
    
    public int[] findMode(TreeNode root) {
        return findModeWithoutMemory(root);
    }
    
    /*
        T: O(N)
        S: O(1)-morris or O(H)- stack,recursive
    */
    private int[] findModeWithoutMemory(TreeNode root){
        ans=new ArrayList<>();
        inorderMorris(root);

        //return ans.stream().mapToInt(i->i).toArray();
        int[] result=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            result[i]=ans.get(i);
        }
        
        return result;
    }
    
    private void count(int val){
         if(val!=prev){
             count=1;
         }else{
             count++;
         }
         if(count>max){
             max=count;
             ans=new ArrayList<>();
             ans.add(val);
         }else if(count==max){
             ans.add(val);
         }
         prev=val;
    }
    
    private void inorderMorris(TreeNode root){
        
        TreeNode curr=root;
        
        while(curr!=null){
            
            if(curr.left!=null){
                
                TreeNode prev=curr.left;
                while(prev.right!=null&&prev.right!=curr){
                    prev=prev.right;
                }
                
                if(prev.right==null){
                    
                    prev.right=curr;
                    curr=curr.left;
                    
                }else{
                    count(curr.val);
                    prev.right=null;
                    curr=curr.right;
                }
                
            }else{
                count(curr.val);
                curr=curr.right;
            }
        }
        
    }
    
    private void inorderStack(TreeNode root){
         
        Stack<TreeNode> stack=new Stack<>();
        TreeNode curr=root;
        
        while(!stack.isEmpty()||curr!=null){
            
            while(curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            
            curr=stack.pop();
            count(curr.val);
            curr=curr.right;       
        }
    }
    
    private void inorder(TreeNode root){
        if(root==null) return;
        
        inorder(root.left);
        count(root.val);
        inorder(root.right);
    }
    
    /*
        T: O(N)
        S: O(N)
    */
    private int[] findModeWithMap(TreeNode root){
        dfs(root);
        int max=-1;
        List<Integer> ans=new ArrayList<>();
        for(int n:counter.keySet()){
            if(counter.get(n)>max){
                ans=new ArrayList<>();
                max=counter.get(n);
            }
            if(counter.get(n)==max){
                ans.add(n);
            }
        }
        
        //return ans.stream().mapToInt(i->i).toArray();
        int[] result=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            result[i]=ans.get(i);
        }
        
        return result;
    }
    
    private void dfs(TreeNode root){
        if(root!=null){
            
            counter.put(root.val,counter.getOrDefault(root.val,0)+1);
            dfs(root.left);
            dfs(root.right);
        }
    }
}