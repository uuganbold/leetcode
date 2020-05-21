class Solution812 {

    /*
        T: O(N^3)
        S: O(1)
    */
    public double largestTriangleArea(int[][] points) {
         double ans=0;
         for(int x=0;x<points.length-2;x++){
             for(int y=x+1;y<points.length-1;y++){
                 for(int z=y+1;z<points.length;z++){
                     ans=Math.max(ans,
                                 area(points[x],points[y],points[z]));
                 }
             }
         }
        
        return ans;
    }
    
    /*
        Formula for calculating area of triangle. Worth to memorize;
    */
    private double area(int[] X, int[] Y, int Z[]){
        return 0.5*Math.abs(
            X[0]*(Y[1]-Z[1])+
            Y[0]*(Z[1]-X[1])+
            Z[0]*(X[1]-Y[1])
        );
    }
}