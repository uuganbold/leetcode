import java.util.*;
class Solution874 {

    /*
        commands:C
        obstacles O

        T: O(C+O)
        S: O(O)
    */
    public int robotSim(int[] commands, int[][] obstacles) {
         Map<Integer,Set<Integer>> obs=new HashMap<>();
         for(int[] oneObstacle:obstacles){
             Set<Integer> ys=obs.get(oneObstacle[0]);
             if(ys==null){
                 ys=new HashSet<>();
                 obs.put(oneObstacle[0],ys);
             }
             ys.add(oneObstacle[1]);
         }
        
         int[] pos=new int[]{0,0};
         int[] dir=new int[]{1,1};
        
         int max=0;
         for(int com:commands){
              switch(com){
                  case -2:{
                      dir[0]^=1;
                      if(dir[0]==0){
                          dir[1]=-1*dir[1];
                      }
                      break;
                  }
                  case -1:{
                      dir[0]^=1;
                      if(dir[0]==1){
                          dir[1]=-1*dir[1];
                      }
                      break;
                  }
                  default:{
                      for(int i=0;i<com;i++){
                          pos[dir[0]]+=dir[1];
                          if(obs.get(pos[0])!=null&&obs.get(pos[0]).contains(pos[1])){
                              pos[dir[0]]-=dir[1];
                              break;
                          }
                      }
                      
                      int dist=pos[0]*pos[0]+pos[1]*pos[1];
                      if(dist>max){
                          max=dist;
                      }
                      
                  }
              }
         }
        
        return max;
    }
}