class Solution1037 {

    /*
        T: O(1)
        S: O(1)
    */
    public boolean isBoomerang(int[][] points) {
        int diffX=points[1][0]-points[0][0];//0
        int diffY=points[1][1]-points[0][1];//2
        
        int diffX1=points[2][0]-points[0][0];//2
        int diffY1=points[2][1]-points[0][1];//0
        
        if(diffX*diffY1!=diffY*diffX1){
            return true;
        }
        
        return false;
    }
}