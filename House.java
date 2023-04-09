import java.util.ArrayList;

/**
 * Contains all code for the House class
 */

public class House extends Building {

  private ArrayList<String> residents;
  private boolean hasDiningRoom; 
  private boolean hasElevator;

  /**
 * Constructs a House
 *
 * @param name
 * @param address
 * @param nFloors
 * @param hasDiningRoom
 * @param hasElevator
 */

  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    System.out.println("You have built a house: 🏠");
    ArrayList<String> residents = new ArrayList<String>();
    this.residents = residents;
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
  
  }

    /**
 * Constructs a House
 *
 * @param name
 * @param address
 * @param nFloors
 * @param hasDiningRoom
 * @param hasElevator
 * @param wallColor
 */

  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator, String wallColor) {
    super(name, address, nFloors);
    System.out.println("You have built a house: 🏠");
    ArrayList<String> residents = new ArrayList<String>();
    this.residents = residents;
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
  
  }

    /**
 * Constructs a House
 *
 * @param name
 * @param address
 * @param nFloors
 * @param hasDiningRoom
 * @param hasElevator
 * @param nRooms
 */

  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator, int nRooms) {
    super(name, address, nFloors);
    System.out.println("You have built a house: 🏠");
    ArrayList<String> residents = new ArrayList<String>();
    this.residents = residents;
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
  
  }

  /**
 * Creates a String description
 *
 * @return description
 */

  public String toString() {
    String description = super.toString();
    description += " There are currently " + this.residents.size() + " residents in this house. ";
    description += "This house ";
    if (this.hasDiningRoom) {
      description += "has ";
    } else {
      description += "does not have ";
    }
    description += "a dining room.";
    return description;
  }

  /**
 * Gets value of hasDiningRoom (whether there is a dining room or not)
 *
 * @return this.hasDiningRoom
 */

  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /**
 * Gets number of residents
 *
 * @return this.nResidents.size()
 */

  public int nResidents() {
    return this.residents.size();
  }

  /**
 * Moves in a person
 *
 * @param resName
 */

  public void moveIn(String resName) {
    this.residents.add(resName);
  }

  /**
 * Moves out a person
 *
 * @param resName
 * @return the name of the person who moved out
 */

  public String moveOut(String resName) { 
    if (this.residents.toString().contains(resName)) {
      this.residents.remove(resName);
      return resName;
    } else {
      return "This resident is not in " + getName();
    }
  }

/**
 * Checks if a resident is in the house
 *
 * @param resName
 * @return true or false, depending on if they are in the house
 */

  public boolean isResident(String resName) {
    if (this.residents.toString().contains(resName)) {
      System.out.println(resName + " is a resident of " + getName());
      return true; }
    else {
      System.out.println(resName + " is not a resident of " + getName());
      return false; }
    }
 
    /**
 * Prints options of how to interact with the house.
 */

  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()");
    if (hasElevator) {
      System.out.println(" + goToFloor(n)");
    }
    System.out.println(" + moveIn(name) \n + moveOut(name)");
}

    /**
 * Changes to a different floor number, if possible.
 *
 * @param floorNum
 */

  public void goToFloor(int floorNum) {
    if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
    }
    if (hasElevator) {
      System.out.println("Entering elevator...");
      System.out.println("You are now on floor #" + floorNum + " of " + this.name);
      System.out.println("Exiting elevator...");
      this.activeFloor = floorNum;
    } else {
      throw new RuntimeException(this.name + " doesn't have an elevator. Try using goUp() or goDown() instead.");
    }
    
  }
  
  /**
 * Creates an instance of the House class
 *
 * @param args The command line arguments (ignored)
 */

  public static void main(String[] args) {
    House chase = new House("Chase House", "45 Elm Street", 3, true, true);
    System.out.println(chase);
    //   Testing:
    // chase.moveIn("Sophia Smith");
    // System.out.println("Sophia Smith moved into Chase House");
    // System.out.println("Number of residents: " + chase.nResidents());
    // chase.isResident("Sophia Smith");
    // chase.moveOut("Sophia Smith");
    // System.out.println("Sophia Smith moved out of Chase House");
    // System.out.println("Number of residents: " + chase.nResidents());
    // chase.isResident("Sophia Smith");
    // chase.enter();
    // chase.showOptions();
    // chase.goToFloor(2);




    

  }

}