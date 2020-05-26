class Solution387 {

    /*
        T: O(N)
        S: O(1)
    */
    public int firstUniqChar(String s) {
        int occurance=0;
        int duplicated=0;
        
        for(char ch:s.toCharArray()){
            int shift=ch-'a';
            
            if((occurance&(1<<shift))!=0){
                duplicated|=1<<shift;
            }else{
                occurance|=1<<shift;
            }
        }
        
        for(int i=0;i<s.length();i++){
            int shift=s.charAt(i)-'a';
            if((duplicated&(1<<shift))==0) return i;
        }
        
        return -1;
    }
}