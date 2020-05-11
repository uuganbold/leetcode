class Solution922 {

    /*
        T: O(N)
        S: O(1)
    */
    public int[] sortArrayByParityII(int[] A) {
        
        for(int even=0,odd=1;even<A.length;){
            if(A[even]%2==0) { even+=2; continue;}
            if(A[odd]%2==1) {odd+=2; continue;}
            swap(A,even,odd);
        }
        
        return A;
    }

    public int[] sortArrayByParity2(int[] A) {       
        for(int even=0,odd=1;even<A.length;even+=2){
            if(A[even]%2==1){
                while(A[odd]%2==1) odd+=2;
                int temp=A[even];
                A[even]=A[odd];
                A[odd]=temp;
            }       
        }        
        return A;
    }
    
    private void swap(int[] A, int i, int j){
        int temp=A[i];
        A[i]=A[j];
        A[j]=temp;
    }
}
