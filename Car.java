class Car extends Vehicle {
  int wheels;
  
  Car(float inputPrice, int inputSeats, String inputColor, int inputWheels){
    super(inputPrice, inputSeats, inputColor);
    wheels = inputWheels;
  }
}