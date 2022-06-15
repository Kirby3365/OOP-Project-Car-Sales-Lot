class Main {
  public static void main(String[] args) {
    //Clear the console
    System.out.print("\033[H\033[2J");
    System.out.flush();
    
    Commands commands = new Commands();

    //Start the first menu
    commands.LoginOptions();
  }
}