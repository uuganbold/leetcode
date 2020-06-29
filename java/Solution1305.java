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
class Solution1305 {
    
    /*
        T: O(2*N)
        S: O(N)
    */
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        LinkedList<Integer> list1=new LinkedList<>();
        LinkedList<Integer> list2=new LinkedList<>();
        toArray(root1,list1);
        toArray(root2,list2);
        
        ArrayList<Integer> result=new ArrayList<>(list1.size()+list2.size());
        while(!list1.isEmpty()&&!list2.isEmpty()){
            if(list1.peekFirst()>list2.peekFirst()){
                result.add(list2.poll());
            }else result.add(list1.poll());
        }
        while(!list1.isEmpty()) result.add(list1.poll());
        while(!list2.isEmpty()) result.add(list2.poll());
        return result;
    }
    
    void toArray(TreeNode root,LinkedList<Integer> list){
        if(root!=null){
             toArray(root.left,list);
             list.add(root.val);
             toArray(root.right,list);            
        }
    }
    
    /*
        T: O(N)
        S: O(N)
    */
    public List<Integer> getAllElements1(TreeNode root1, TreeNode root2) {
        List<Integer> ans=new ArrayList<>();
        Stack<TreeNode> stack1=new Stack<TreeNode>();
        Stack<TreeNode> stack2=new Stack<TreeNode>();
        
        while((root1!=null||!stack1.isEmpty())&&
              (root2!=null||!stack2.isEmpty())){
            
             while(root1!=null){
                 stack1.push(root1);
                 root1=root1.left;
             }
            
            while(root2!=null){
                stack2.push(root2);
                root2=root2.left;
            }
            
             TreeNode node;
            // System.out.println(stack1.peek().val+"x"+stack2.peek().val);
             if(stack1.peek().val<stack2.peek().val){
                 root1=stack1.pop();
                 ans.add(root1.val);
                 root1=root1.right;
           
             }else{
                 root2=stack2.pop();
                 ans.add(root2.val);
                 root2=root2.right;
       
             }
            
        }
        
        while(root1!=null||!stack1.isEmpty()){
            while(root1!=null){
                 stack1.push(root1);
                 root1=root1.left;
             }
            root1=stack1.pop();
             ans.add(root1.val);
             root1=root1.right;
        }
        
        
        while(root2!=null||!stack2.isEmpty()){
            while(root2!=null){
                 stack2.push(root2);
                 root2=root2.left;
             }
             root2=stack2.pop();
             ans.add(root2.val);
             root2=root2.right;
        }
        
        return ans;
    }
}