public class Solution1381 {
    class CustomStackSimple{
        private int[] memory;
        private int pointer=0;
        public CustomStackSimple(int maxSize) {
            memory=new int[maxSize];
            pointer=0;
        }
        
        public void push(int x) {
            if(pointer<memory.length){
                memory[pointer++]=x;
            }
        }
        
        public int pop() {
            if(pointer>0){
                return memory[--pointer];
            }else{
                return -1;
            }
        }
        
        public void increment(int k, int val) {
            for(int i=0;i<k&&i<pointer;i++){
                memory[i]+=val;
            }
        }
    }

    class CustomStack {

        private int[] memory;
        private int pointer;
        
        public CustomStack(int maxSize) {
            memory=new int[maxSize];
            pointer=0;
        }
        
        public void push(int x) {
            if(pointer<memory.length){
                memory[pointer]=x;
                if(pointer>0){
                    memory[pointer-1]-=x;
                }
                pointer++;
            }
            
        }
        
        public int pop() {
            if(pointer>0){
                pointer--;
                if(pointer>0){
                    memory[pointer-1]+=memory[pointer];
                }
                return memory[pointer];
            }
            return -1;
        }
        
        public void increment(int k, int val) {
            if(k>0&&pointer>0){
                memory[Math.min(k,pointer)-1]+=val;
            }
            
        }
    }
    
    /**
     * Your CustomStack object will be instantiated and called as such:
     * CustomStack obj = new CustomStack(maxSize);
     * obj.push(x);
     * int param_2 = obj.pop();
     * obj.increment(k,val);
     */
}