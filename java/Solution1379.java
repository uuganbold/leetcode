/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 import java.util.*;
class Solution1379 {

    /*
        T: O(N)
        S: O(H)
    */
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original==null||target==null){
            return null;
        }
        return dfsMorris(original, cloned, target);
    }
    
    private final TreeNode dfsMorris(TreeNode original, TreeNode cloned, TreeNode target){
        
        while(original!=null){
            
            if(original.left!=null){
                
                TreeNode temp=original.left;
                TreeNode cloneTemp=cloned.left;
                while(temp.right!=null&&temp.right!=original){
                    temp=temp.right;
                    cloneTemp=cloneTemp.right;
                }
                
                if(temp.right==null){
                    if(original==target){
                        return cloned;
                    }
                    
                    
                    temp.right=original;
                    original=original.left;
                    
                    cloneTemp.right=cloned;
                    cloned=cloned.left;
                }else{
                    temp.right=null;
                    original=original.right;
                    
                    cloneTemp.right=null;
                    cloned=cloned.right;
                }    
            }else{
                if(original==target){
                    return cloned;
                }
                original=original.right;     
                cloned=cloned.right;
                
            }     
        }
        
        return null;
        
    }
    
    private final TreeNode dfsStack(TreeNode original, TreeNode cloned, TreeNode target){
        if(original==null||target==null){
            return null;
        }
        
        if(original==target){
            return cloned;
        }
        
        Stack<TreeNode> stack=new Stack<>();
        stack.push(original);
        stack.push(cloned);
        while(!stack.isEmpty()){
            cloned=stack.pop();
            original=stack.pop();
            
            if(original.left!=null){
                if(original.left==target){
                    return cloned.left;
                }
                
                stack.push(original.left);
                stack.push(cloned.left);
            }
            
            if(original.right!=null){
                if(original.right==target){
                    return cloned.right;
                }
                
                stack.push(original.right);
                stack.push(cloned.right);
            }
        }
        
        return null;
    }
    
    private final TreeNode bfs(TreeNode original, TreeNode cloned, TreeNode target){
        if(original==null){
            return null;
        }
        if(original==target){
            return cloned;
        }
        
        Queue<TreeNode> queue=new LinkedList<>();
        
        queue.offer(original);
        queue.offer(cloned);
        while(!queue.isEmpty()){
            original=queue.poll();
            cloned=queue.poll();
            
            if(original.left!=null){
                if(original.left==target){
                    return cloned.left;
                }
                queue.offer(original.left);
                queue.offer(cloned.left);
            }
            
            if(original.right!=null){
                if(original.right==target){
                    return cloned.right;
                }
                queue.offer(original.right);
                queue.offer(cloned.right);
            }
        }
        
        return null;
        
    }
    
    private final TreeNode dfsRecurse(TreeNode original, TreeNode cloned, TreeNode target){
        if(original==null){
            return null;
        }
        if(original==target){
            return cloned;
        }
        
        TreeNode child=dfsRecurse(original.left, cloned.left,target);
        if(child!=null){
            return child;
        }
        
        return dfsRecurse(original.right,cloned.right,target);
    }
}