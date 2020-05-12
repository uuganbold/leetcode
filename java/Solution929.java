import java.util.*;
class Solution929 {

    /*
        T: O(N-number of chars)
        S: O(N)
    */
    public int numUniqueEmails(String[] emails) {
        Set<String> uniq=new HashSet<>();
        for(String email:emails){
            StringBuilder str=new StringBuilder();
            
            int i=0;
            while(true){
                char ch=email.charAt(i++);
                if(ch=='+'||ch=='@') break;
                if(ch=='.') continue;
                str.append(ch);
                
            }
            str.append(email.substring(email.indexOf('@')));
            uniq.add(str.toString());
        }
        
        return uniq.size();
    }
}