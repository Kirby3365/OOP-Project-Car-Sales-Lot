import java.util.Scanner;

class Commands{

  VehicleDatabase database = new VehicleDatabase();
  Scanner scanner = new Scanner(System.in);
  public String input;
  boolean isEmployee;
  int selectedNum;
  String selectedVehicle;

  //Creating a vehicle
  int inputWheels;
  float inputPrice;
  int inputSeats;
  String inputColor;
  float inputLoadCap;

  //First Screen
  void LoginOptions(){
    System.out.print("\033[H\033[2J");
    System.out.flush();
    
    System.out.println("Welcome to the car sales lot.");
    System.out.println("Login as a Employee or Customer?");
    
    input = scanner.nextLine();
    
    if(input.toLowerCase().equals("employee")){
      System.out.println();
      System.out.println("You are logged in as an employee. To go back anytime, type back.");
      isEmployee = true;
      EmployeeOptions();
    }
    else if (input.toLowerCase().equals("customer")){
      System.out.println();
      System.out.println("You are logged in as a customer. To go back anytime, type back.");
      isEmployee = false;
      CustomerOptions();
    }
    else{
      System.out.println();
      System.out.println("That is not a valid commmand. Please try again");
      System.out.println();
      LoginOptions();
    }
  }

  //Menu for Employee Options
  void EmployeeOptions(){
    System.out.println();
    System.out.println("Would you like to view, search, or edit the vehicle database?");
    input = scanner.nextLine();
    if(input.toLowerCase().equals("view")){
      ViewVehicles();
    }
    if(input.toLowerCase().equals("search")){
      SearchForVehicle();
    }
    else if(input.toLowerCase().equals("edit")){
      EditVehicles();
    }
    else if(input.toLowerCase().equals("back")){
      System.out.println();
      LoginOptions();
    }
    else{
      System.out.println("That is not a valid commmand. Please try again");
      System.out.println();
      EmployeeOptions();
    }
  }

  //Menu for Customer Options
  void CustomerOptions(){
    System.out.println();
    System.out.println("Would you like to view, search, or buy a vehicle?");
    input = scanner.nextLine();
      
    if(input.toLowerCase().equals("view")){
      ViewVehicles();
    }
    if(input.toLowerCase().equals("search")){
      SearchForVehicle();
    }
    else if(input.toLowerCase().equals("buy")){
      PurchaceVehicle();
    }
    else if(input.toLowerCase().equals("back")){
      System.out.println();
      LoginOptions();
    }
    else{
      System.out.println("That is not a valid commmand. Please try again");
      System.out.println();
      CustomerOptions();
    }
  }

  //Menu for Customer Buying a Vehicle
  void PurchaceVehicle(){
    System.out.println();
    System.out.println("What type of vehicle would you like to purchace? (Car, Motorcycle, Truck)");
    selectedVehicle = scanner.nextLine();
    selectedVehicle = selectedVehicle.toLowerCase();
    System.out.println();
    
    if(selectedVehicle.toLowerCase().equals("back")){
      System.out.println();
      EmployeeOptions();
    }
    
    if(!((selectedVehicle.equals("car") || selectedVehicle.equals("motorcycle") || selectedVehicle.equals("truck")))){
      System.out.println("That is not a valid commmand. Please try again");
      System.out.println();
      PurchaceVehicle();
    }
    if(database.VehicleArrSize(selectedVehicle) <= 0){
       System.out.println("There are no " + selectedVehicle + "s in stock. Please try again later.");
       CustomerOptions();
    }
    database.ViewVehicles(selectedVehicle);
    System.out.println("What vehicle number would you like to purchace?");
    selectedNum = scanner.nextInt();
    scanner.nextLine();
      
    if(selectedNum < database.VehicleArrSize(selectedVehicle)){
      System.out.println();
      if(database.RemoveVehicle(selectedVehicle, selectedNum))
        System.out.println("Successfully bought " + selectedVehicle + " " + selectedNum + ". Please come again!");
      else{
        System.out.println("Something went wrong. Please try again");
        PurchaceVehicle();
      } 
    }
    else if(input.toLowerCase().equals("back")){
      System.out.println();
      CustomerOptions();
    }
    else{
      System.out.println("That is not a valid number. Please try again");
      PurchaceVehicle();
    }

    CustomerOptions();
  }

  //Menu for Viewing Vehicles
  void ViewVehicles(){
    System.out.println();
    System.out.println("What type of vehicle would you like to view? (Car, Motorcycle, Truck, All)");
    selectedVehicle = scanner.nextLine();

    if(selectedVehicle.toLowerCase().equals("back")){
      System.out.println();
      if(isEmployee)
        EmployeeOptions();
      else
        CustomerOptions();
    }
    
    if((selectedVehicle.equals("car") || selectedVehicle.equals("motorcycle") || selectedVehicle.equals("truck") || selectedVehicle.equals("all"))){
      System.out.println();
      database.ViewVehicles(selectedVehicle.toLowerCase());
    }
    else{
      System.out.println("That is not a valid commmand. Please try again");
      ViewVehicles();
    }
      
    if(isEmployee)
      EmployeeOptions();
    else
      CustomerOptions();
  }

  //Menu for Searching a Vehicle
  void SearchForVehicle(){
    System.out.println();
    System.out.println("What type of vehicle would you like to search for? (Car, Motorcycle, Truck)");
    selectedVehicle = scanner.nextLine();
    selectedVehicle = selectedVehicle.toLowerCase();
    System.out.println();
    
    if(selectedVehicle.toLowerCase().equals("back")){
      if(isEmployee)
        EmployeeOptions();
      else
        CustomerOptions();
    }

    if(!((selectedVehicle.equals("car") || selectedVehicle.equals("motorcycle") || selectedVehicle.equals("truck")))){
      System.out.println("That is not a valid commmand. Please try again");
      System.out.println();
      SearchForVehicle();
    }
    
    System.out.println("What Search type would you like to use? (Color, Price)");
    input = scanner.nextLine();
    
    if(input.toLowerCase().equals("color")){
      System.out.println("What color would you like to search for?");
      input = scanner.nextLine();
      database.ViewByColor(selectedVehicle, input);
    }
    else if(input.toLowerCase().equals("price")){
      database.ViewByPrice(selectedVehicle);
    }
    else if(input.toLowerCase().equals("back")){
      if(isEmployee)
        EmployeeOptions();
      else
        CustomerOptions();
    }
    else{
      System.out.println("That is not a valid commmand. Please try again");
      SearchForVehicle();
    }

    if(isEmployee)
      EmployeeOptions();
    else
      CustomerOptions();
  }

  //Menu for Employees too edit the database
  void EditVehicles(){
    System.out.println();
    System.out.println("What type of vehicle would you like to edit? (Car, Motorcycle, Truck)");
    selectedVehicle = scanner.nextLine();
    selectedVehicle = selectedVehicle.toLowerCase();
    System.out.println();
    
    if(selectedVehicle.toLowerCase().equals("back")){
      EmployeeOptions();
    }
    
    if(!((selectedVehicle.equals("car") || selectedVehicle.equals("motorcycle") || selectedVehicle.equals("truck")))){
      System.out.println("That is not a valid commmand. Please try again");
      System.out.println();
      EditVehicles();
    }

    System.out.println("Would you like to add or remove a vehicle?");
    input = scanner.nextLine();
    System.out.println();
      
    if(input.toLowerCase().equals("add")){
      //Wheels, price, seats, color, load capacity(Trucks)
      System.out.println("How many wheels does the vehicle have?");
      inputWheels = scanner.nextInt();
      scanner.nextLine();
      System.out.println();
      System.out.println("How expensive is the vehicle?");
      inputPrice = scanner.nextFloat();
      scanner.nextLine();
      System.out.println();
      System.out.println("How many seats does the vehicle have?");
      inputSeats = scanner.nextInt();
      scanner.nextLine();
      System.out.println();
      System.out.println("What color is the vehicle?");
      inputColor = scanner.nextLine();
      System.out.println();

      if(selectedVehicle.equals("truck")){
        System.out.println("What is the load capacity? (numbers and decimals only)");
      inputLoadCap = scanner.nextFloat();
      scanner.nextLine();
      System.out.println();
      }

      switch(selectedVehicle){
        case "car":
          database.AddCar(inputPrice, inputSeats, inputColor, inputWheels);
          break;
        case "truck":
          database.AddTruck(inputPrice, inputSeats, inputColor, inputWheels, inputLoadCap);
          break;
        case "motorcycle":
          database.AddMotorcycle(inputPrice, inputSeats, inputColor, inputWheels);
          break;
        default:
          System.out.println("Unknown vehicle type for adding vehicle.");
        break;        
      }
      
      System.out.println("Successfully added new vehicle");
    }
    else if(input.toLowerCase().equals("remove")){
      database.ViewVehicles(selectedVehicle);
      System.out.println("What vehicle number would you like to remove?");
      selectedNum = scanner.nextInt();
      scanner.nextLine();
      System.out.println();
      
      if(selectedNum < database.VehicleArrSize(selectedVehicle)){
        if(database.RemoveVehicle(selectedVehicle, selectedNum))
          System.out.println("Successfully removed vehicle " + selectedNum);
        else{
          System.out.println("Something went wrong. Please try again");
          EditVehicles();
        } 
      }
      else if(input.toLowerCase().equals("back")){
        System.out.println();
        LoginOptions();
      }
      else{
        System.out.println("That is not a valid number. Please try again");
        EditVehicles();
      }
    }
    else if(input.toLowerCase().equals("back")){
      EmployeeOptions();
    }
    else{
      System.out.println("That is not a valid commmand. Please try again");
      EditVehicles();
    }

    EmployeeOptions();
  }
}