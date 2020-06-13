class Solution434 {

    /*
        T: O(N)
        S: O(1)
    */
    public int countSegments(String s) {
        int count=0;
        boolean whitespace=true;
        
        for(int i=0;i<s.length();i++){
            if(whitespace&&s.charAt(i)!=' '){
                count++;
            }
            whitespace=s.charAt(i)==' ';
        }
        
        return count;
    }
}