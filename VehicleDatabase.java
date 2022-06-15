import java.util.ArrayList;

class VehicleDatabase {
  private ArrayList<Car> carsInLot = new ArrayList<Car>();
  private ArrayList<Truck> trucksInLot = new ArrayList<Truck>();
  private ArrayList<Motorcycle> motorcyclesInLot = new ArrayList<Motorcycle>();

  //Set up example vehicles
  VehicleDatabase(){
    carsInLot.add(new Car(1500.58f, 5, "black", 4));
    carsInLot.add(new Car(1400.58f, 6, "blue", 4));
    trucksInLot.add(new Truck(2000.58f, 5, "brown", 4, 1000));
    trucksInLot.add(new Truck(2500.58f, 2, "black", 4, 2000));
    motorcyclesInLot.add(new Motorcycle(1000.58f, 2, "black", 3));
    motorcyclesInLot.add(new Motorcycle(1200.58f, 1, "red", 2));
  } 

  //Add a vehicle to the database
  public void AddCar(float inputPrice, int inputSeats, String inputColor, int inputWheels){
    carsInLot.add(new Car(inputPrice, inputSeats, inputColor, inputWheels));
  }

  public void AddTruck(float inputPrice, int inputSeats, String inputColor, int inputWheels, float inputLoadCapicity){
    trucksInLot.add(new Truck(inputPrice, inputSeats, inputColor, inputWheels, inputLoadCapicity));
  }

  public void AddMotorcycle(float inputPrice, int inputSeats, String inputColor, int inputWheels){
    motorcyclesInLot.add(new Motorcycle(inputPrice, inputSeats, inputColor, inputWheels));
  }

  //View the database
  public int VehicleArrSize(String vehicleType){
    switch(vehicleType){
      case "car":
        return carsInLot.size();
      case "truck":
        return trucksInLot.size();
      case "motorcycle":
        return motorcyclesInLot.size();
      case "all":
        System.out.println("Can't select all when finding array length.");
        break;
      default:
        System.out.println("Unknown vehicle type for VehicleArrSize.");
        break;
    }
    return 0;
  }
  
  public boolean RemoveVehicle(String vehicleType, int num){
   switch(vehicleType){
      case "car":
        carsInLot.remove(num);
        break;
      case "truck":
        trucksInLot.remove(num);
        break;
      case "motorcycle":
        motorcyclesInLot.remove(num);
        break;
      case "all":
        System.out.println("Can't select all when removing a vehicle.");
        return false;
      default:
        System.out.println("Unknown vehicle type for RemoveVehicle.");
        return false;
    }
    return true;
  }
  
  public void ViewVehicles(String vehicleType){
    switch(vehicleType){
      case "car":
        for (int i = 0 ; i < carsInLot.size() ; i++){
          System.out.println("Car " + i + " :");
          System.out.println("  Price : " + carsInLot.get(i).price + "$");
          System.out.println("  Seats : " + carsInLot.get(i).seats);
          System.out.println("  Color : " + carsInLot.get(i).color);
          System.out.println("  Wheels : " + carsInLot.get(i).wheels);
          System.out.println("");
        }
        break;
      case "truck":
        for (int i = 0 ; i < trucksInLot.size() ; i++){
          System.out.println("Truck " + i + " :");
          System.out.println("  Price : " + trucksInLot.get(i).price + "$");
          System.out.println("  Seats : " + trucksInLot.get(i).seats);
          System.out.println("  Color : " + trucksInLot.get(i).color);
          System.out.println("  Wheels : " + trucksInLot.get(i).wheels);
          System.out.println("  Load Capicity : " + trucksInLot.get(i).loadCapicity);
          System.out.println("");
        }
        break;
      case "motorcycle":
        for (int i = 0 ; i < motorcyclesInLot.size() ; i++){
          System.out.println("Motorcycle " + i + " :");
          System.out.println("  Price : " + motorcyclesInLot.get(i).price + "$");
          System.out.println("  Seats : " + motorcyclesInLot.get(i).seats);
          System.out.println("  Color : " + motorcyclesInLot.get(i).color);
          System.out.println("  Wheels : " + motorcyclesInLot.get(i).wheels);
          System.out.println("");
        }
        break;
      case "all":
        for (int i = 0 ; i < motorcyclesInLot.size() ; i++){
          System.out.println("Motorcycle " + i + " :");
          System.out.println("  Price : " + motorcyclesInLot.get(i).price + "$");
          System.out.println("  Seats : " + motorcyclesInLot.get(i).seats);
          System.out.println("  Color : " + motorcyclesInLot.get(i).color);
          System.out.println("  Wheels : " + motorcyclesInLot.get(i).wheels);
          System.out.println("");
        }
        for (int i = 0 ; i < trucksInLot.size() ; i++){
          System.out.println("Truck " + i + " :");
          System.out.println("  Price : " + trucksInLot.get(i).price + "$");
          System.out.println("  Seats : " + trucksInLot.get(i).seats);
          System.out.println("  Color : " + trucksInLot.get(i).color);
          System.out.println("  Wheels : " + trucksInLot.get(i).wheels);
          System.out.println("  Load Capicity : " + trucksInLot.get(i).loadCapicity);
          System.out.println("");
        }
        for (int i = 0 ; i < carsInLot.size() ; i++){
          System.out.println("Car " + i + " :");
          System.out.println("  Price : " + carsInLot.get(i).price + "$");
          System.out.println("  Seats : " + carsInLot.get(i).seats);
          System.out.println("  Color : " + carsInLot.get(i).color);
          System.out.println("  Wheels : " + carsInLot.get(i).wheels);
          System.out.println("");
        }
        break;
      default:
        System.out.println("Unknown vehicle type for ViewVehicles.");
        break;
    }
  }

  public void ViewByPrice(String vehicleType){
    //Sort Array into temp new
    boolean sorted = false;
    
    switch(vehicleType){
      case "car":     
        Car tempCar;
        while (!sorted) {
          sorted = true;
          for (int i = 1; i < carsInLot.size(); i++) {
            if (carsInLot.get(i - 1).price > carsInLot.get(i).price) {
              tempCar = carsInLot.get(i - 1);
              carsInLot.set(i - 1, carsInLot.get(i));
              carsInLot.set(i, tempCar);
              sorted = false;
            }
          }
        }
        for (int i = 0 ; i < carsInLot.size() ; i++){
          System.out.println("Car " + i + " :");
          System.out.println("  Price : " + carsInLot.get(i).price + "$");
          System.out.println("  Seats : " + carsInLot.get(i).seats);
          System.out.println("  Color : " + carsInLot.get(i).color);
          System.out.println("  Wheels : " + carsInLot.get(i).wheels);
          System.out.println("");
        }
        break;
      case "truck":
        Truck tempTruck;
        while (!sorted) {
          sorted = true;
          for (int i = 1; i < trucksInLot.size(); i++) {
            if (trucksInLot.get(i - 1).price > trucksInLot.get(i).price) {
              tempTruck = trucksInLot.get(i - 1);
              trucksInLot.set(i - 1, trucksInLot.get(i));
              trucksInLot.set(i, tempTruck);
              sorted = false;
            }
          }
        }
        for (int i = 0 ; i < trucksInLot.size() ; i++){
          System.out.println("Truck " + i + " :");
          System.out.println("  Price : " + trucksInLot.get(i).price + "$");
          System.out.println("  Seats : " + trucksInLot.get(i).seats);
          System.out.println("  Color : " + trucksInLot.get(i).color);
          System.out.println("  Wheels : " + trucksInLot.get(i).wheels);
          System.out.println("  Load Capicity : " + trucksInLot.get(i).loadCapicity);
          System.out.println("");
        }
        break;
      case "motorcycle":
        Motorcycle tempMotorcycle;
        while (!sorted) {
          sorted = true;
          for (int i = 1; i < motorcyclesInLot.size(); i++) {
            if (motorcyclesInLot.get(i - 1).price > motorcyclesInLot.get(i).price) {
              tempMotorcycle = motorcyclesInLot.get(i - 1);
              motorcyclesInLot.set(i - 1, motorcyclesInLot.get(i));
              motorcyclesInLot.set(i, tempMotorcycle);
              sorted = false;
            }
          }
        }
        for (int i = 0 ; i < motorcyclesInLot.size() ; i++){
          System.out.println("Motorcycle " + i + " :");
          System.out.println("  Price : " + motorcyclesInLot.get(i).price + "$");
          System.out.println("  Seats : " + motorcyclesInLot.get(i).seats);
          System.out.println("  Color : " + motorcyclesInLot.get(i).color);
          System.out.println("  Wheels : " + motorcyclesInLot.get(i).wheels);
          System.out.println("");
        }
        break;
      default:
        System.out.println("Unknown vehicle type for ViewByPrice.");
        break;
    }
  }

  public void ViewByColor(String vehicleType, String searchColor){
    switch(vehicleType){
      case "car":
        for (int i = 0 ; i < carsInLot.size() ; i++){
          if(!searchColor.equals(carsInLot.get(i).color))
            continue;
          System.out.println("Car " + i + " :");
          System.out.println("  Price : " + carsInLot.get(i).price + "$");
          System.out.println("  Seats : " + carsInLot.get(i).seats);
          System.out.println("  Color : " + carsInLot.get(i).color);
          System.out.println("  Wheels : " + carsInLot.get(i).wheels);
          System.out.println("");
        }
        break;
      case "truck":
        for (int i = 0 ; i < trucksInLot.size() ; i++){
          if(!searchColor.equals(trucksInLot.get(i).color))
            continue;
          System.out.println("Truck " + i + " :");
          System.out.println("  Price : " + trucksInLot.get(i).price + "$");
          System.out.println("  Seats : " + trucksInLot.get(i).seats);
          System.out.println("  Color : " + trucksInLot.get(i).color);
          System.out.println("  Wheels : " + trucksInLot.get(i).wheels);
          System.out.println("  Load Capicity : " + trucksInLot.get(i).loadCapicity);
          System.out.println("");
        }
        break;
      case "motorcycle":
        for (int i = 0 ; i < motorcyclesInLot.size() ; i++){
          if(!searchColor.equals(motorcyclesInLot.get(i).color))
            continue;
          System.out.println("Motorcycle " + i + " :");
          System.out.println("  Price : " + motorcyclesInLot.get(i).price + "$");
          System.out.println("  Seats : " + motorcyclesInLot.get(i).seats);
          System.out.println("  Color : " + motorcyclesInLot.get(i).color);
          System.out.println("  Wheels : " + motorcyclesInLot.get(i).wheels);
          System.out.println("");
        }
        break;
      default:
        System.out.println("Unknown vehicle type for ViewVehicles.");
        break;
    }
  }
}