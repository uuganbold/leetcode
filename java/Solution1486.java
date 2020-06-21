class Solution1486 {
    
    /*
        T: O(1)
        S: O(1)

        this solution depends on the fact that start^(start+2)==2 when start%4 is 0 or 1. 

    */
    public int xorOperation(int n, int start){
        int last=start+(n-1)*2;
        
        if(start%4<=1){
            
            if(n%4==0){
                return 0;
            }else if(n%4==1){
                return last;
            }else if(n%4==2){
                return 2;
            }else{
                return 2^last;
            }
            
        }else{
            
            if((n-1)%4==0){
                return start;
            }else if((n-1)%4==1){
                return start^last;
            }else if((n-1)%4==2){
                return start^2;
            }else {
                return start^2^last;
            }
            
            
        }
        
    }
    
    /*
        T: O(n)
        S: O(1)
    */
    public int xorOperationLoop(int n, int start) {
        int ans=start;
        for(int i=1;i<n;i++){
            int num=start+2*i;
            ans^=num;
        }
        
        return ans;
    }
    
    
}