class Solution733 {

    /*
        T: O(N)
        S: O(N)
    */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
       int oldColor=image[sr][sc];
       if(newColor==oldColor) return image;
       floodFillRecurse(image,sr,sc,newColor,oldColor);
        
        return image;
    }
    
    private void floodFillRecurse(int[][] image, int sr, int sc, int newColor, int oldColor){
        if(sr<0||sr>=image.length) return;
        if(sc<0||sc>=image[sr].length) return;
        
        if(image[sr][sc]==oldColor){
            image[sr][sc]=newColor;
            
            floodFillRecurse(image,sr-1,sc,newColor,oldColor);
            floodFillRecurse(image,sr+1,sc,newColor,oldColor);
            floodFillRecurse(image,sr,sc-1,newColor,oldColor);
            floodFillRecurse(image,sr,sc+1, newColor, oldColor);
        } 
        
    }
}