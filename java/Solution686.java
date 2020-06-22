class Solution686 {

    /*
        T: O(N*(M+N))
        S: O(M+N)
    */
    public int repeatedStringMatch(String A, String B) {
        StringBuilder S=new StringBuilder();
        int count=0;
        while(S.length()<B.length()){
            S.append(A);
            count++;
        }
        
        if(S.indexOf(B)>=0){
            return count;
        }
        
        if(S.append(A).indexOf(B)>=0){
            return count+1;
        }
        
        return -1;
    }
}