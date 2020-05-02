import java.util.Set;
import java.util.HashSet;
class Solution804 {
    private final String[] MORSE_CODE={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    
    /**
     * T: O(n)
     * S: O(n)
     */
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set=new HashSet<>();
        for(String word:words){
            StringBuilder builder=new StringBuilder();
            for(char letter:word.toCharArray()){
                builder.append(MORSE_CODE[letter-'a']);
            }
            set.add(builder.toString());
        }
        return set.size();
    }
}