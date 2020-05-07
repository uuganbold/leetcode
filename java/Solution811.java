import java.util.*;
class Solution811 {
    
    /*
        T: O(N)
        S: O(N)
    */
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String,Integer> domainVisitMap=new HashMap<>();
        
        for(String cpdomain:cpdomains){
            int whiteSpace=cpdomain.indexOf(" ");
            int visit=Integer.parseInt(cpdomain.substring(0,whiteSpace));
            String domain = cpdomain.substring(whiteSpace+1);
            
            while(true){
                int currentVisit=domainVisitMap.getOrDefault(domain,0);
                domainVisitMap.put(domain,currentVisit+visit);
                
                int dot=domain.indexOf(".");
                if(dot==-1) break;
                else domain=domain.substring(dot+1);
            }
            
        }
        
        List<String> result=new ArrayList<>();
        for(String domain:domainVisitMap.keySet()){
             result.add(domainVisitMap.get(domain)+" "+domain);
        }
        
        return result;
    }
}