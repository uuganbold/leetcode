import java.util.*;
class Solution937 {
    
    private static class LogItem implements Comparable<LogItem>{
        String identifier;
        String content;
        boolean isLetterLog;
        int originalOrder;
        
        public LogItem(String id, String c, int o, boolean isLet){
            this.identifier=id;
            this.content=c;
            this.originalOrder=o;
            this.isLetterLog=isLet;
        }
        
        public String toString(){
            return identifier+" "+content;
        }
        
        public int compareTo(LogItem other){
            if(isLetterLog&&!other.isLetterLog) return -1;
            if(!isLetterLog&&other.isLetterLog) return 1;
            
            if(isLetterLog&&other.isLetterLog){
                int diffCont= content.compareTo(other.content);
                if(diffCont==0){
                    return identifier.compareTo(other.identifier);
                }else{
                    return diffCont;
                }
            }else{
                return originalOrder-other.originalOrder;
            }
        }
    }
    
    /*
        T: O(NlogN)
        S: O(N)
    */
    public String[] reorderLogFiles(String[] logs) {
        LogItem[] items=new LogItem[logs.length];
        
        for(int i=0;i<logs.length;i++){
            String log=logs[i];
            int space=log.indexOf(' ');
            items[i]=new LogItem(log.substring(0,space),log.substring(space+1),i,Character.isLetter(log.charAt(space+1)));
        }
        
        Arrays.sort(items);
        
        for(int i=0;i<items.length;i++){
            logs[i]=items[i].toString();
        }
        
        return logs;
        
    }
}