import java.util.*;
class Solution690 {

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
    
    Map<Integer, Employee> empMap;

    /*
        T: O(N)
        S: O(N)
    */
    public int getImportance(List<Employee> employees, int id) {
        empMap=new HashMap<>(employees.size());
        for(Employee e:employees){
            empMap.put(e.id,e);
        }
        
        return dfsIterative(id);
    }
    
    private int dfsRecursive(int id){
        Employee employee=empMap.get(id);
        if(employee==null) return 0;
        int importance=employee.importance;
        for(Integer subordinate:employee.subordinates){
            importance+=dfsRecursive(subordinate);
        }
        return importance;
    }
    
    private int dfsIterative(int id){
        int sumImport=0;
        Stack<Integer> stack=new Stack<>();
        
        stack.push(id);
        
        while(!stack.isEmpty()){
            Employee employee=empMap.get(stack.pop());
            if(employee==null) continue;
            
            sumImport+=employee.importance;
            
            for(int sub:employee.subordinates){
                stack.push(sub);
            }
            
        }
        
        return sumImport;
    }
}