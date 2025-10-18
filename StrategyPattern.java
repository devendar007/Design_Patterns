public class StrategyPattern{
    public static void main(String[] args){
        Vehicle v1=new PassengerVehicle();
        v1.Drive();
        Vehicle v2=new SportyVehicle();
        v2.Drive();
    }
}
interface VehicleStrategy {
    void drive();
}
class NormalDrive implements VehicleStrategy {
    public void drive() {
        System.out.println("Driving in normal mode.");
    }
}
class SpecialDrive implements VehicleStrategy {
    public void drive() {
        System.out.println("Driving in special mode.");
    }
}
class Vehicle{
  VehicleStrategy obj;
  Vehicle(VehicleStrategy obj){
      this.obj=obj;      //whether its normaldrive or specialdrive
  }
  void Drive(){
      obj.drive();
  }
  
}
class PassengerVehicle extends Vehicle{
  PassengerVehicle(){
      super(new NormalDrive());
  }
  

}
class SportyVehicle extends Vehicle{
   SportyVehicle(){
       super(new SpecialDrive());
   }
}
class OffroadVehicle extends Vehicle{
 OffroadVehicle(){
     super(new SpecialDrive());
 }
}
