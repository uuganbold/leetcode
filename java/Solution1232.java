class Solution1232 {
    /*
        T:O(N)
        S:O(1)
    */
    public boolean checkStraightLine(int[][] coordinates) {
        int xDiff=coordinates[1][0]-coordinates[0][0];
        int yDiff=coordinates[1][1]-coordinates[0][1];
        
        for(int i=2;i<coordinates.length;i++){
            if(xDiff*(coordinates[i][1]-coordinates[0][1])!=
               yDiff*(coordinates[i][0]-coordinates[0][0])){
                return false;
            }
        }
        
        return true;
    }
}