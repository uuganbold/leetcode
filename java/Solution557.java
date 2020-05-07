class Solution557 {

    /*
        T: O(N)
        S: O(N)
    */
    public String reverseWords(String s) {
        char[] str=s.toCharArray();
        
        int start=0,end=0;
        
        while(end<str.length){
            start=end;
            while(end<str.length&&str[end]!=' '){
                end++;
            }
            reverseSingleWord(str,start,end);
            end++;            
        }

        return new String(str);
    }
    
    private void reverseSingleWord(char[] sentence, int from, int end){
          while(from<end){
              char temp=sentence[from];
              sentence[from]=sentence[end-1];
              sentence[end-1]=temp;
              from++;
              end--;
          }
    } 
}