class Solution338 {
    
    public int[] countBits(int num){
        
        int[] ans=new int[num+1];
        
        for(int i=1;i<=num;i++){
            ans[i]=ans[i&(i-1)]+1;
        }
        
        return ans;
        
    }
    
    public int[] countBits1(int num) {
        /*
        [0,1,2,3,4,5,6,7,8,9,10]
        [0,1,1,2,1,2,2,3,1,2,]
        
        */
        
        if(num==0){
            return new int[]{0};
        }
        
        if(num==1){
            return new int[]{0,1};
        }
        
        int[] ans=new int[num+1];
        ans[0]=0;
        ans[1]=1;
        
        int powerOfTwo=2;
        for(int i=2;i<=num;i++){
            if(i==powerOfTwo*2){
                powerOfTwo=powerOfTwo*2;
            }
            int val=ans[i-powerOfTwo/2];
            if(i>=powerOfTwo+powerOfTwo/2){
                val+=1;
            }
            ans[i]=val;
        }
        
        return ans;
    }
}