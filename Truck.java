class Truck extends Vehicle {
  int wheels;
  float loadCapicity;

  Truck(float inputPrice, int inputSeats, String inputColor, int inputWheels, float inputLoadCapicity){
    super(inputPrice, inputSeats, inputColor);
    wheels = inputWheels;
    loadCapicity = inputLoadCapicity;
  }
}