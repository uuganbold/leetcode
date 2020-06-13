class Solution949 {

    /*
        T: O(1)
        S: O(1)
    */
    public String largestTimeFromDigits(int[] A) {
        int hour=-1, minute=-1;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(i!=j){
                    int h=10*A[i]+A[j];
                         
                    for(int m=0;m<4;m++){
                        if(m!=i&&m!=j){
                            int n=6-i-j-m;
                            int min=10*A[m]+A[n];
                            if(h<24&&min<60&&(h>hour||(h==hour&&min>minute))){
                                hour=h;
                                minute=min;
                            }
                        }
                    }
                    
                }
            }
        }
        
        if(hour==-1){
            return "";
        }else{
            return String.format("%02d:%02d",hour,minute);
        }
        
        
    }
}