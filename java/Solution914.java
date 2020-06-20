import java.util.*;
class Solution914 {
    

    /*
        T: O(NlogN)
        S: O(N)
    */
    public boolean hasGroupsSizeX(int[] deck) {
        int[] count=new int[10000];
        for(int c:deck) count[c]++;
        
        int g=-1;
        for(int i=0;i<1000;++i){
            if(count[i]>0){
                if(g==-1)
                    g=count[i];
                else{
                    g=gcd(g,count[i]);
                }
                    
                 if(g<2) return false;   
            }
        }
        return g>=2;
    }
    
    public boolean hasGroupsSizeXZ(int[] deck){
         if(deck.length<=1){
             return false;
         }
        
         Map<Integer,Integer> counts=new HashMap<>();
        for(int card:deck){
            counts.put(card,counts.getOrDefault(card,0)+1);
        }
        
        int num=2;
        while(true){
            boolean divided=true;
            for(int card:deck){
                int count=counts.get(card);
                if(count<num){
                    return false;
                }
                if(count%num!=0){
                    divided=false;
                    break;
                }
            }
            if(divided){
                return true;
            }else{
                num++;
            }
        }
        
    }
    public boolean hasGroupsSizeXY(int[] deck) {
        if(deck==null||deck.length<=1){
            return false;
        }
        
        Map<Integer, Integer> counts=new HashMap<>();
        for(int card:deck){
            counts.put(card,counts.getOrDefault(card,0)+1);
        }
        
        int gcd=counts.get(deck[0]);
        for(int card:counts.keySet()){
            gcd=gcd(gcd,counts.get(card));
            if(gcd==1){
                return false;
            }
        }
        
        
        
        return true;
    }
    
    public int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }
}