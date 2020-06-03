class Solution492 {

    /*
        T: O(sqrt(N))
        S: O(1)
    */
    public int[] constructRectangle(int area) {
        int sqrt=(int)Math.sqrt(area);
        
        int width=sqrt;
        for(;width>=1;width--){
            if(area%width==0) break;
        }
        
        return new int[]{area/width,width};
    } 
}