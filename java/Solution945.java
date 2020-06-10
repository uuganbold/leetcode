class Solution945 {

    /*
        T: O(N+T)
        S: O(1)
    */
    public boolean isLongPressedNamesd(String name, String typed) {
        int n=0;
        int t=0;

        while(n<name.length()&&t<typed.length()){
            char nChar=name.charAt(n);
            char tChar=typed.charAt(t);
            
            if(nChar!=tChar){
                return false;
            }
            
            int nameCounter=0;
            int typedCounter=0;
            
            while(n<name.length()&&name.charAt(n)==nChar){
                n++;
                nameCounter++;
            }
            
            while(t<typed.length()&&typed.charAt(t)==tChar){
                t++;
                typedCounter++;
            }
            
            if(typedCounter<nameCounter){
                return false;
            }
        }
        
        if(n<name.length()||t<typed.length()){
            return false;
        }
        
        return true;
        
    }
}