class Solution1266 {
    /*
    T: O(n)
    S: O(1)
    */
    public int minTimeToVisitAllPoints(int[][] points) {
         int time=0;
         for(int i=1;i<points.length;i++){
             int h=Math.abs(points[i][0]-points[i-1][0]);
             int v=Math.abs(points[i][1]-points[i-1][1]);
             time+=Math.max(h,v);
         }
        return time;
    }
}