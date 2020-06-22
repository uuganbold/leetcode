class Solution605 {

    /*
        T: O(N)
        S: O(1)
    */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        int empty=1;
        for(int flower:flowerbed){
            if(flower!=0){
                n=n-(empty-1)/2;
                empty=0;
            }else{
                empty++;
            }
        }
        
        n=n-empty/2;
        
        return n<=0;
            
    }
}