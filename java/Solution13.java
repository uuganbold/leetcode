import java.util.*;
class Solution13 {

    /*
        T: O(N)
        S: (1)
    */
    public int romanToInt(String s) {
        Map<Character,Integer> map=new HashMap<>(){{
            put('I',1);
            put('V',5);
            put('X',10);
            put('L',50);
            put('C',100);
            put('D',500);
            put('M',1000);
        }};
        
        int val=0;
        
        for(int i=0;i<s.length();i++){
            int thisLetterValue=map.get(s.charAt(i));
            int nextLetterValue=i+1<s.length()?map.get(s.charAt(i+1)):0;
            
            if(thisLetterValue<nextLetterValue){
                val+=-thisLetterValue;
            }else{
                val+=thisLetterValue;
            }
        }
        
        return val;
    }
}