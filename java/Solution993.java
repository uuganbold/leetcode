import java.util.*;
class Solution993 {

     public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }

    /*
         T: O(N)
         S: O(N)
    */
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue=new LinkedList<>();
        
        queue.offer(null);
        queue.offer(root);
        
        while(!queue.isEmpty()){
            
            Queue<TreeNode> temp=new LinkedList<>();
            TreeNode foundParent=null;
            
            while(!queue.isEmpty()){
                TreeNode parent=queue.poll();
                TreeNode node=queue.poll();

                if(node.val==x||node.val==y){
                    if(foundParent==null){
                        foundParent=parent;
                    }else{
                        if(foundParent!=parent){
                            return true;
                        }else return false;
                    }
                }
                
                if(node.left!=null){
                    temp.offer(node);
                    temp.offer(node.left);
                }
                
                if(node.right!=null){
                    temp.offer(node);
                    temp.offer(node.right);
                }
            }
            
            if(foundParent!=null) return false; 
            queue=temp;
        }
        
        return false;
    }
}