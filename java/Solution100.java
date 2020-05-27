import java.util.*;
class Solution100 {

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
         S: O(1)
    */
    public boolean isSameTree(TreeNode p, TreeNode q){
        TreeNode curP=p;
        TreeNode curQ=q;
        TreeNode prevP;
        TreeNode prevQ;
        
        while(curP!=null&&curQ!=null){
            
            if(curP.left==null){
                if(curQ.left!=null) return false;
                if(!checkEquality(curP,curQ)) return false;
                curP=curP.right;
                curQ=curQ.right;
            }else{
                if(curQ.left==null) return false;
                prevP=curP.left;
                prevQ=curQ.left;
                
                while(prevP.right!=null&&prevP.right!=curP){
                    prevP=prevP.right;
                    if(prevQ==null) return false;
                    prevQ=prevQ.right;
                }
                
                if(prevP.right==curP){
                    if(prevQ.right!=curQ) return false;
                    prevP.right=null;
                    prevQ.right=null;
                    curP=curP.right;
                    curQ=curQ.right;
                }else{
                    if(!checkEquality(curP,curQ)) return false;
                    prevP.right=curP;
                    prevQ.right=curQ;
                    curP=curP.left;
                    curQ=curQ.left;
                }
            }
        }
        
        if(curP!=null||curQ!=null){
            return false;
        }
        
        return true;    
    } 
    

    private boolean checkEquality(TreeNode p, TreeNode q){
        if(p==null&&q==null) return true;
        if(p==null||q==null) return false;
        
        return p.val==q.val;
    }
    
    /*
        T:O(N)
        S:O(H)
    */
    public boolean isSameTreeStack(TreeNode p, TreeNode q){
        Stack<TreeNode> stackP=new Stack<>();
        Stack<TreeNode> stackQ=new Stack<>();
        stackP.push(p);
        stackQ.push(q);
        
        while(!stackP.isEmpty()&&!stackQ.isEmpty()){
            
            TreeNode nodeP=stackP.pop();
            TreeNode nodeQ=stackQ.pop();
            
            if(nodeP==null&&nodeQ==null) continue;
            
            if(nodeP==null||nodeQ==null) return false;
             
            if(nodeP.val!=nodeQ.val) return false;
            
            stackP.push(nodeP.right);
            stackQ.push(nodeQ.right);
            
            stackP.push(nodeP.left);
            stackQ.push(nodeQ.left);
        }
        
        if(!stackQ.isEmpty()||!stackP.isEmpty()) return false;
        return true;
        
    } 

    /*
        T: O(N)
        S: O(H)
    */
    public boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
        if(p==null&&q==null) return true;
        if(p==null||q==null) return false;
        
        if(p.val!=q.val) return false;
        
        if(!isSameTreeRecursive(p.left,q.left)) return false;
        
        if(!isSameTreeRecursive(p.right,q.right)) return false;

        return true;
    }
}