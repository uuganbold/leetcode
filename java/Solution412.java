import java.util.*;
class Solution412 {

    /*
        T: O(n)
        S: O(1)
    */
    public List<String> fizzBuzz(int n) {
        List<String> ans=new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(i%15==0){
                ans.add("FizzBuzz");
            }else if(i%5==0){
                ans.add("Buzz");
            }else if(i%3==0){
                ans.add("Fizz");
            }else{
                ans.add(String.valueOf(i));
            }
        }
        return ans;
    }


    /*
        T: O(N)
        S: O(1)
    */
    public List<String> fizzBuzzExtensible(int n) {
        List<String> ans=new ArrayList<>();
        
        Map<Integer,String> mapping=new HashMap<>(){
            {
                put(3,"Fizz");
                put(5,"Buzz");
            }
        };
        
        for(int i=1;i<=n;i++){
            StringBuilder builder=new StringBuilder("");
            for(int key:mapping.keySet()){
                if(i%key==0) builder.append(mapping.get(key));
            }
            
            if(builder.length()==0){
                builder.append(i);
            }
            
            ans.add(builder.toString());
        }
        return ans;
    }
}