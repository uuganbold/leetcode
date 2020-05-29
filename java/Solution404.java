import java.util.*;
class Solution404 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeavesMorris(root);
        
    }

    /*
        T:O(N)
        S:O(1)
    */
    private int sumOfLeftLeavesMorris(TreeNode root){
        int sum=0;
        TreeNode node=root;
        
        while(node!=null){
            
            if(node.left!=null){
               
                TreeNode cur=node.left;
                while(cur.right!=null&&cur.right!=node){
                    cur=cur.right;
                }
                
                if(cur.right==null){
                    cur.right=node;
                    node=node.left;
                    if(cur==node&&cur.left==null){
                        sum+=cur.val;
                    }
                }else{ 
                    cur.right=null;
                    node=node.right;
                }
                
            }else{
                node=node.right;
            }
            
        }
        
        return sum;
    }

    /*
        T: O(N)
        S: O(N)
    */
    private int sumOfLeftLeavesBFS(TreeNode root){
        if(root==null) return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        
        queue.offer(root);
        int sum=0;
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            
            if(node.left!=null){
                 if(node.left.left==null&&node.left.right==null){
                     sum+=node.left.val;
                 }else{
                     queue.offer(node.left);
                 }
            }
            
            if(node.right!=null){
                 queue.offer(node.right);
            }
                
        }
        
        return sum;
    }

    /*
        T: O(N)
        S: O(H)
    */
    private int sumOfLeftLeavesDFS(TreeNode root){
        if(root==null) return 0;
        Stack<TreeNode> stack=new Stack<>();
        
        stack.push(root);
        int sum=0;
        while(!stack.isEmpty()){
            
            TreeNode node=stack.pop();
            
            if(node.right!=null){
                 stack.push(node.right);
            }
            
            if(node.left!=null){
                 if(node.left.left==null&&node.left.right==null){
                     sum+=node.left.val;
                 }else{
                     stack.push(node.left);
                 }
            }           
        }
        
        return sum;
        
    }

    /*
        T: O(N)
        S: O(H)
    */
    private int sumOfLeftLeavesRecurse(TreeNode root, boolean isLeft){
        if(root==null) return 0;
        if(root.left==null&&root.right==null&&isLeft){
             return root.val;
        }
        
        return sumOfLeftLeavesRecurse(root.left,true)+sumOfLeftLeavesRecurse(root.right,false);
    }
}