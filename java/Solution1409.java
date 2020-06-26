class Solution1409 {
    
    /*
        T: O(m*q)
        S: O(m)
    */
    public int[] processQueries(int[] queries, int m) {
        
        int[] p = new int[m];
        int[] result = new int[queries.length];
        
        for(int i = 0; i < m; i++) p[i] = i+1;
        
        for(int i = 0; i < queries.length; i++){
            
            int[] array = p.clone();
            int cursor = 1;
            
            for(int j = 0; j < p.length; j++){
                if(queries[i] == p[j]){
                    array[0] = p[j];
                    result[i] = j;
                    break;
                }else{
                    array[cursor] = p[j];
                    cursor++;    
                }
            }
            p = array;
        }
        
        return result;
    }
    
    public int[] processQueries1(int[] queries, int m){
        int[] ans=new int[queries.length];
        
        int[] p=new int[m];
        for(int i=0;i<m;i++){
            p[i]=i+1;
        }
        
        for(int i=0;i<queries.length;i++){
             int q=queries[i];
            
            int j=0;
            while(p[j]!=q){
                j++;
            }
            ans[i]=j;
            
            while(j>0){
                p[j]=p[j-1];
                j--;
            }
            p[0]=q;
        }
        
        return ans;
        
    }
    
    /*
        T:O(m*q)
        S:(2*m)
    */
    public int[] processQueries2(int[] queries, int m) {
        int[] ans=new int[queries.length];
        
        int[] p=new int[2*m];
        for(int i=m;i<2*m;i++){
            p[i]=i-m+1;
        }
        int start=m;
        for(int i=0;i<queries.length;i++){
            int q=queries[i];
            
            int empty=0;
            int j=start;
            while(p[j]!=q){
                if(p[j]==0){
                    empty++;
                }
                j++;
            }
            ans[i]=j-start-empty;
            p[--start]=q;
            p[j]=0;
        }
        
        return ans;
    }
}