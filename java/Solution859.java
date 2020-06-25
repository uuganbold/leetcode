class Solution859 {

    /*
        T: O(N)
        S: O(1)
    */
    public boolean buddyStrings(String A, String B) {
        
        if(A.length()!=B.length()){
            return false;
        }
        
        int prevA=-1;
        int prevB=-1;
        
        int nextA=-1;
        int nextB=-1;
        
        int occ=0;
        boolean duplicated=false;
        
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)!=B.charAt(i)){
                if(nextA!=-1){
                    return false;
                }
                if(prevA==-1){
                    prevA=(int)A.charAt(i);
                    prevB=(int)B.charAt(i);
                }else{
                    nextA=(int)A.charAt(i);
                    nextB=(int)B.charAt(i);
                }
            }else{
                int mask=1<<(A.charAt(i)-'a');
                if((occ&mask)>0){
                    duplicated=true;
                }else{
                    occ=occ|mask;
                }
            }
        }
        
        if(prevA==-1){
            if(duplicated){
                return true;
            }
            return false;
        }else{
            return prevA==nextB&&prevB==nextA;
            
        }
        
        
    }
}