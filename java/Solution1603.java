public class Solution1603 {
    class ParkingSystem {

        int[] lots;
        public ParkingSystem(int big, int medium, int small) {
            lots=new int[]{big,medium,small};
        }
        
        public boolean addCar(int carType) {
            if(lots[carType-1]>0){
                lots[carType-1]--;
                return true;
            }else{
                return false;
            }
        }
    }
    
    /**
     * Your ParkingSystem object will be instantiated and called as such:
     * ParkingSystem obj = new ParkingSystem(big, medium, small);
     * boolean param_1 = obj.addCar(carType);
     */
}
