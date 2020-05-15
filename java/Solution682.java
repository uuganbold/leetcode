class Solution682 {

    /*
        T: O(N)
        S: O(N)
    */
    public int calPoints(String[] ops) {
        int[] stack=new int[ops.length];
        int pointer=0;
        
        for(String str:ops){
            switch(str){
                case "+":{
                    stack[pointer]=stack[pointer-2]+stack[pointer-1];
                    pointer++;
                    break;
                }
                case "D":{
                    stack[pointer]=stack[pointer-1]*2;
                    pointer++;
                    break;
                }
                case "C":{
                    pointer--;
                    break;
                }
                default:{
                    int point=Integer.parseInt(str);
                    stack[pointer++]=point;
                }
            }
        }
        
        int sum=0;
        for(int i=0;i<pointer;i++){
            sum+=stack[i];
        }
        
        return sum;
    }
}