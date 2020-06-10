class Solution849 {

    /*
        T: O(N)
        S: O(1)
    */
    public int maxDistToClosest(int[] seats) {
        int max=0;
        boolean first=true;
        int count=0;
        
        for(int i=0;i<seats.length;i++){
            if(seats[i]==0&&first){
                max++;
            }else if(seats[i]==0){
                count++;
            }else{
                if((count+1)/2>max){
                    max=(count+1)/2;
                }
                first=false;
                count=0;
            }
        }
        
        if(count>max){
            max=count;
        }
        
        return max;
    }
}