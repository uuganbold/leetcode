class Solution986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        /*
        [[10,12],[18,19]]
        [[1,6],[8,11],[13,17],[19,20]]
        */
        
        int N=A.length;
        int M=B.length;
        
        int i=0;
        int j=0;
        
        int[][] ans=new int[N+M][];
        int k=0;
        while(i<N&&j<M){
            int[] a=A[i];
            int[] b=B[j];
            
            if(isIntersect(a,b)){
               ans[k++]=intersection(a,b); 
            }
            if(a[1]>b[1]){
                j++;
            }else{
                i++;
            }
        }
        
        return Arrays.copyOf(ans,k);
    }
    
    private boolean isIntersect(int[] a, int[] b){
        return a[0]>=b[0]&&a[0]<=b[1]||b[0]>=a[0]&&b[0]<=a[1];
    }
    
    private int[] intersection(int[] a, int[] b){
        
        return new int[]{Math.max(a[0],b[0]),Math.min(a[1],b[1])};
        
    }
    
    
}