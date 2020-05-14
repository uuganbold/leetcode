import java.util.*;
class Solution1030 {
    
    /*
        N=R*C
        T: O(NLogN)
        S: O(N)
    */
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0){
         PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
              return a[0]-b[0];
         });
             
         for(int r=0;r<R;r++){
            for(int c=0;c<C;c++){
                int dist=Math.abs(r-r0)+Math.abs(c-c0);
                pq.add(new int[]{dist,r,c});
            }
         }
        
         int[][] ans=new int[R*C][2];
        int idx=0;
         while(!pq.isEmpty()){
              int[] coord=pq.poll();
              ans[idx][0]=coord[1];
             ans[idx][1]=coord[2];
             idx++;
         }
        
        return ans;
    }
    
    /*
        N=R*C
        T: O(NLogN)
        S: O(N)
    */
    public int[][] allCellsDistOrderSort(int R, int C, int r0, int c0){
        
        int[][] result=new int[R*C][2];
        
        int idx=0;
        for(int r=0;r<R;r++){
            for(int c=0;c<C;c++){
                result[idx++]=new int[]{r,c};
            }
        }
        
        Arrays.sort(result,(coord1,coord2)->{
            return Math.abs(coord1[0]-r0)+Math.abs(coord1[1]-c0)
                -Math.abs(coord2[0]-r0)-Math.abs(coord2[1]-c0);
        });
        
        return result;
        
    }
    
    /*
        T: O(R*C)
        S: O(R*C)
    */
    public int[][] allCellsDistOrderList(int R, int C, int r0, int c0){
        List<List<int[]>> ans=new ArrayList<>();
        for(int i=0;i<R+C;i++){
            ans.add(new ArrayList<>());
        }
        
        for(int r=0;r<R;r++){
            for(int c=0;c<C;c++){
                int dist=Math.abs(r0-r)+Math.abs(c0-c);
                ans.get(dist).add(new int[]{r,c});
            }
        }
        
        int[][] result=new int[R*C][2];
        int i=0;
        for(List<int[]> sameDist:ans){
            for(int[] coord:sameDist){
                result[i++]=coord;
            }
        }
        
        return result;
    }
    
    /*
        T: O(R*C)
        S: O(1)
    */
    public int[][] allCellsDistOrderMessy(int R, int C, int r0, int c0) {
        int[][] result=new int[R*C][2];
        
        result[0]=new int[]{r0,c0};
        
        int dist=1;
        int count=1;
        
        while(count<R*C){
            
            for(int r_dist=-1*dist;r_dist<=dist;r_dist++){
                int r=r0+r_dist;
                if(r>=0&&r<R){
                    int c_dist=dist-Math.abs(r_dist);
                    
                    if(c_dist==0){
                        result[count++]=new int[]{r,c0};
                    }else{
                       if(c0-c_dist>=0){
                            result[count++]=new int[]{r,c0-c_dist};
                        }

                        if(c0+c_dist<C){
                            result[count++]=new int[]{r,c0+c_dist};
                        } 
                    }
                             
                }
            }
            ++dist;
            
        }
        
        return result;
        
    }
}