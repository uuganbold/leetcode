class Solution443 {

    /*
        T: O(N)
        S: O(1)
    */
    public int compress(char[] chars) {
        int write=0;
        int lastChar=0;
        
        for(int read=0;read<=chars.length;read++){
            if(read==chars.length||chars[read]!=chars[lastChar]){
                 int count=read-lastChar;
                 chars[write++]=chars[lastChar];
                 write=putCountInPlace(chars,write,count);
                 lastChar=read;
            }
        }
        
        return write;
    }
    
    /*
        T: O(logC)
    */
    private int putCountInPlace(char[] chars, int start,int count){
        if(count==1){
            return start;
        }
        
        int end=start;
        while(count>0){
            chars[end++]=(char)(count%10+'0');
            count/=10;
        }
        int ans=end;
        while(start<end-1){
            char temp=chars[start];
            chars[start]=chars[end-1];
            chars[end-1]=temp;
            start++;
            end--;
        }
        
        return ans;
    }

}