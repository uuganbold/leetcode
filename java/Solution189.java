class Solution189 {
    
    /*
        T: O(N)
        S: O(1)
    */
    public void rotate(int[] nums, int k){
        k=k%nums.length;
        int count=0;
        
        for(int start=0;count<nums.length;start++){
            int current=start;
            int prev=nums[current];
            do{
                int next=(current+k)%nums.length;
                int temp=nums[next];
                nums[next]=prev;
                prev=temp;
                current=next;
                count++;
            }while(current!=start);
        }
        
    }
    
    /*
        T: O(N+N%K)
        S: O(N%K)
    */
    public void rotateBig(int[] nums, int k){
        if(nums.length<=1){
            return;
        }
        
        k=k%nums.length;
        
        int[] temp=new int[k];
        for(int i=nums.length-k;i<=nums.length-1;i++){
            temp[i+k-nums.length]=nums[i];
        }
        
        for(int i=nums.length-1;i-k>=0;i--){
            nums[i]=nums[i-k];
        }
        
        for(int i=0;i<k;i++){
            nums[i]=temp[i];
        }
        
    }
    
    /*
        T: O(N*K)
        S: O(1)
    */
    public void rotateSlow(int[] nums, int k) {
        if(nums.length<=1){
            return;
        }
        
        k=k%nums.length;
        
        for(int i=0;i<k;i++){
            int temp=nums[nums.length-1];
            for(int j=nums.length-1;j>0;j--){
                nums[j]=nums[j-1];
            }
            nums[0]=temp;
        }
    }
}