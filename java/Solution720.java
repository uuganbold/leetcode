class Solution720 {
    
    private final static int ALPHABET_SIZE=26;
    
    private class TrieNode{
        TrieNode[] children=new TrieNode[ALPHABET_SIZE];
        boolean isWord=false;
        String content;
        
        public TrieNode(){
            
        }
        
        public TrieNode(boolean isWord, String content){
            this.isWord=isWord;
            this.content=content;
        }
    }
    
    TrieNode root=new TrieNode(true,"");
    
    private void insert(String word){
        TrieNode curr=root;
        TrieNode child;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            child=curr.children[ch-'a'];
            if(child==null){
                child=new TrieNode();
                curr.children[ch-'a']=child;
            }
            curr=child;
        }
        curr.content=word;
        curr.isWord=true;
    }
    
    private String longestPath(TrieNode root){
        if(root==null||!root.isWord) return null;
        
        String max=root.content;
        for(TrieNode child:root.children){
            String childLongest=longestPath(child);
            if(childLongest!=null&&childLongest.length()>max.length()){
                max=childLongest;
            }
        }
        
        return max;
        
    }
    
    /*
        T: O(W)
        S: O(W)
    */
    public String longestWord(String[] words) {
        for(String w:words){
            insert(w);
        }
        
        return longestPath(root);
    }
}