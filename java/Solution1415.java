class Solution1415 {
    
    private char[] happy;
    private int count;
    private char[] set;
    private int N;
    private int K;
    public String getHappyString(int n, int k) {
        
        this.N=n;
        this.K=k;
        this.happy=new char[N];
        this.count=0;
        this.set=new char[]{'a','b','c'};
        
        backtrack(0);
        
        if(this.count<K){
            return "";
        }else{
            return new String(happy);
        }
    }
    
    /*
        T: O(N*3)
        S: O(1)
    */
    private void backtrack(int pos){
        if(pos==N){
            this.count++;
            return;
        }
        for(int i=0;i<set.length;i++){
            if(pos==0||happy[pos-1]!=set[i]){
                this.happy[pos]=set[i];
                backtrack(pos+1);
                if(this.count>=this.K){
                    return;
                }
            }
        }
    }
}