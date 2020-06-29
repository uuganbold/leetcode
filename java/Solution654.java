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
class Solution654 {
    /*
        T: O(N^2)
        S: O(N)
    */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        LinkedList<TreeNode> stack=new LinkedList<>();
        for(int n:nums){
            TreeNode node=new TreeNode(n);
            TreeNode child=null;
            while(!stack.isEmpty()&&stack.peekLast().val<node.val){
                child=stack.removeLast();
            }
            node.left=child;
            if(!stack.isEmpty()){
                stack.peekLast().right=node;
            }
            stack.add(node);
        }
        return stack.peekFirst();
    }
    
    
    /*
        T: O(n*n)
        S: O(n)
    */
    private TreeNode helper(int[] nums, int left, int right){
        if(left==right){
            return null;
        }
        int max=Integer.MIN_VALUE;
        int idx=-1;
        for(int i=left;i<right;i++){
            if(nums[i]>max){
                max=nums[i];
                idx=i;
            }
        }
        TreeNode root=new TreeNode(max);
        root.left=helper(nums,left,idx);
        root.right=helper(nums,idx+1,right);
        return root;
    }
    
   
}