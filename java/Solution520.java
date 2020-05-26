class Solution520 {

    /*
        T: O(N)
        S: O(1)
    */
    public boolean detectCapitalUse(String word) {
         boolean containsSmall=false;
         int capitalCount=0;
         
         for(int i=0;i<word.length();i++){
             if(Character.isUpperCase(word.charAt(i))){
                 if(containsSmall){
                     return false;
                 }
                 ++capitalCount;
             }else{
                 if(capitalCount>1) return false;
                 containsSmall=true;
             }
         }
        
         return true;
    }
    
    
}