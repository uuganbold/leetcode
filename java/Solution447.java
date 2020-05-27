import java.util.*;
class Solution447 {

    /*
        T:O(N^2)
        S:O(N)
    */
    public int numberOfBoomerangs(int[][] points) {
        int count=0;
        for(int i=0;i<points.length;i++){
            Map<Integer,Integer> distances=new HashMap<>();
            for(int j=0;j<points.length;j++){
                if(i!=j){
                    int dist=sqrtDistance(points[i],points[j]);
                    int prev=distances.getOrDefault(dist,0);
                    count+=prev*2;
                    distances.put(dist,prev+1);
                }
            }
        }
        return count;
    }
    
    private int sqrtDistance(int[] point1, int[] point2){
        return (int)(Math.pow(point1[0]-point2[0],2)+Math.pow(point1[1]-point2[1],2));
    }
}