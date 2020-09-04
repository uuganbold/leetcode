class Solution1442 {

    /*
        T: O(N^2)
        S: O(N)
    */
    public int countTriplets(int[] arr) {
        /**
        
        [7,11,12,9,5,2,7,17,22]
        
               [2,3,1,6,7]
        f(i)=  [2,1,0,6,1] cumulative xors
        g(i,j-1)=f(i-1)^f(j-1)
        g(j,k)=f(j-1)^f(k)
        
        f(i-1)=f(k)
        
        we can choose j's as any number between i+1,k as long as f(i-1)==f(k)
        
        **/
        
        int ans=0;
        int N=arr.length;
        int[] xors=new int[N+1];
        xors[0]=0;
        
        for(int k=0;k<N;k++){
            xors[k+1]=xors[k]^arr[k];
            
            for(int i=0;i<k;i++){
                if(xors[i]==xors[k+1]){
                    ans+=k-i;
                }
            }
        }
        
        return ans;
        
    }
}