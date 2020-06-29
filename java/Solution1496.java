import java.util.*;
class Solution1496 {

    /*
        T: O(N)
        S: O(N)
    */
    public boolean isPathCrossing(String path) {
        Set<Integer> history=new HashSet<>();
        history.add(getKey(0,0));
        int x=0;
        int y=0;
        for(char ch:path.toCharArray()){
            switch(ch){
                case 'N':{
                    y++;
                    break;
                }
                case 'S':{
                    y--;
                    break;
                }
                case 'E':{
                    x++;
                    break;
                }
                case 'W':{
                    x--;
                    break;
                }
            }
            int key=getKey(x,y);
            if(history.contains(key)){
                return true;
            }else{
                history.add(key);
            }
            
        }
        
        return false;
    }
    
    private int getKey(int x, int y){
        return x*100000+y;
    }
    
}