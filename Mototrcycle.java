class Motorcycle extends Vehicle {
  int wheels;
  
  Motorcycle(float inputPrice, int inputSeats, String inputColor, int inputWheels){
    super(inputPrice, inputSeats, inputColor);
    wheels = inputWheels;
  }
}