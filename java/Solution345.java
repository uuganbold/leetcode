class Solution345 {

    /*
        T: O(N)
        S: O(N)
    */
    public String reverseVowels(String s) {
        char[] chars=s.toCharArray();
        
        int i=0;
        int j=chars.length-1;
        
        while(i<j){
            while(i<j&&!isVowel(chars[i])){
                i++;
            }
            while(i<j&&!isVowel(chars[j])){
                j--;
            }
            
            if(i<j){
                char temp=chars[i];
                chars[i]=chars[j];
                chars[j]=temp;
                i++;
                j--;                
            }
            

        }
        
        return new String(chars);
    }
    
    private boolean isVowel(Character c) {
        return c == 'a' || c =='e' || c == 'i' || c =='o' || c == 'u'
            || c == 'A' || c =='E' || c == 'I' || c =='O' || c == 'U';
    }
    
    
    private boolean isVowel1(char ch){
        int numericValue=Character.getNumericValue(ch);
        int a=Character.getNumericValue('a');
        int o=Character.getNumericValue('o');
        int u=Character.getNumericValue('u');
        int e=Character.getNumericValue('e');
        int i=Character.getNumericValue('i');
        
        return numericValue==a||
            numericValue==o||
            numericValue==u||
            numericValue==e||
            numericValue==i;
    }
}