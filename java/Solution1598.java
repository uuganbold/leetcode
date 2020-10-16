public class Solution1598 {
    public int minOperations(String[] logs) {
        int deep=0;
        
        for(String command:logs){
            if(command.equals("../")){
                if(deep>0){
                    deep--;
                }
            }else if(!command.equals("./")){
                deep++;
            }
        }
        
        return deep;
    } 
}
