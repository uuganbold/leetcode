import java.util.*;
class Solution1042 {
    int[] vertices;
    int[][] edges;
    
    public int[] gardenNoAdj(int N, int[][] paths) {
        vertices=new int[N];
        edges=new int[N][3];
        
        /*
            T: O(E)
        */
        for(int[] path:paths){ 
            for(int from=0;from<path.length;from++){
                int to=1-from;
                int[] neighbors=edges[path[from]-1];
                for(int i=0;i<neighbors.length;i++){
                    if(neighbors[i]==0){
                        neighbors[i]=path[to];
                        break;
                    }
                }   
            }    
        }
        
        dfs();
        
        return vertices;
    }
    
    private void dfs(){
        for(int i=0;i<vertices.length;i++){
            if(vertices[i]==0){
                Stack<Integer> stack=new Stack<>();
                stack.push(i);
                
                while(!stack.isEmpty()){
                    
                    int curr=stack.pop();
                    int[] neighbors=edges[curr];
                    int[] choices=new int[]{1,2,3,4};
                    
                    for(int n:neighbors){
                        if(n!=0){
                            int color=vertices[n-1];
                            if(color!=0){
                                choices[color-1]=0;
                            }else{
                                stack.push(n-1);
                            }
                        }     
                    }
                    
                    for(int ch:choices){
                        if(ch!=0){
                            vertices[curr]=ch;
                            break;
                        }
                    }
                }
            }
        }
    }
    
    private void bfs(){
        for(int i=0;i<vertices.length;i++){
            if(vertices[i]==0){
                Queue<Integer> queue=new LinkedList<>();
                queue.offer(i);
                
                while(!queue.isEmpty()){
                    
                    int curr=queue.poll();
                    int[] neighbors=edges[curr];
                    int[] choices=new int[]{1,2,3,4};
                    
                    for(int n:neighbors){
                        if(n!=0){
                            int color=vertices[n-1];
                            if(color!=0){
                                choices[color-1]=0;
                            }else{
                                queue.offer(n-1);
                            }
                        }     
                    }
                    
                    for(int ch:choices){
                        if(ch!=0){
                            vertices[curr]=ch;
                            break;
                        }
                    }
                }
            }
        }
    }
    
    /*
        T: O(V)
    */
    private void arraySearch(){
        for(int i=0;i<vertices.length;i++){
            if(vertices[i]==0){
                int[] neighbors=edges[i];
                int[] choices=new int[]{1,2,3,4};
                
                for(int n:neighbors){
                    if(n!=0){
                        int color=vertices[n-1];
                        if(color!=0){
                            choices[color-1]=0;
                        }
                    }     
                }
                
                for(int ch:choices){
                    if(ch!=0){
                        vertices[i]=ch;
                        break;
                    }
                }
            }
        }
    }
    
}