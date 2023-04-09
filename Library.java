import java.util.Hashtable;

/**
 * Contains all code for the Library class
 */

public class Library extends Building {

  private Hashtable<String, Boolean> collection;
  private boolean hasElevator;

  /**
 * Constructs a Library
 *
 * @param name
 * @param address
 * @param nFloors
 * @param hasElevator
 */

  public Library(String name, String address, int nFloors, boolean hasElevator) {
    super(name, address, nFloors);
    System.out.println("You have built a library: 📖");
    Hashtable<String, Boolean> collection = new Hashtable<String, Boolean>();
    this.collection = collection;
    this.hasElevator = hasElevator;
  }

    /**
 * Constructs a Library
 *
 * @param name
 * @param address
 * @param nFloors
 * @param hasElevator
 * @param rating
 */

  public Library(String name, String address, int nFloors, boolean hasElevator, float rating) {
    super(name, address, nFloors);
    System.out.println("You have built a library: 📖");
    Hashtable<String, Boolean> collection = new Hashtable<String, Boolean>();
    this.collection = collection;
    this.hasElevator = hasElevator;
  }

  /**
 * Constructs a Library
 *
 * @param name
 * @param address
 * @param nFloors
 * @param hasElevator
 * @param petFriendly
 */

  public Library(String name, String address, int nFloors, boolean hasElevator, boolean petFriendly) {
    super(name, address, nFloors);
    System.out.println("You have built a library: 📖");
    Hashtable<String, Boolean> collection = new Hashtable<String, Boolean>();
    this.collection = collection;
    this.hasElevator = hasElevator;
  }


    /**
 * Adds a book to the collection.
 *
 * @param title
 */

  public void addTitle(String title) {
    this.collection.put(title, true);
  }

    /**
 * Removes a book from the collection.
 *
 * @param title
 * @return title
 */

  public String removeTitle(String title) {
    this.collection.remove(title);
    return title;
  }

    /**
 * Checks out a book from the collection.
 *
 * @param title
 */

  public void checkOut(String title) {
    this.collection.replace(title, true, false);
  }

    /**
 * Returns a book to the collection.
 *
 * @param title
 */
    
  public void returnBook(String title) {
    this.collection.replace(title, false, true);
  }

    /**
 * Checks if the collection contains a certain book.
 *
 * @param title
 * @return true if the collection contains the book, false otherwise
 */

  public boolean containsTitle(String title) {
    if (this.collection.containsKey(title)) {
      return true;
    } else {
      return false;
    }
  }

    /**
 * Checks if a book is available.
 *
 * @param title
 * @return true if the book is available, false otherwise
 */

  public boolean isAvailable(String title) {
    if (this.collection.get(title).equals(true)) {
      return true;
    } else {
      return false;
    } 
  }

    /**
 * Prints collection of books.
 */

  public void printCollection() {
    this.collection.forEach((title, status)->System.out.print(title + " : " + status));

  }

    /**
 * Prints options of how to interact with the library.
 */

  public void showOptions() {
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()");
      if (hasElevator) {
        System.out.println(" + goToFloor(n)");
      }
      System.out.println(" + addTitle(title) \n + removeTitle(title) \n + checkOut(title) \n + returnBook(title)");
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
 * Creates an instance of the Library class
 *
 * @param args The command line arguments (ignored)
 */
   
  public static void main(String[] args) {
    Library leaf = new Library("Leaf Library", "324 Oak Avenue", 4, true);
    System.out.println(leaf);
    //    Testing:
    // leaf.addTitle("The Lorax by Dr. Seuss");
    // leaf.enter();
    // leaf.showOptions();
    // leaf.goToFloor(4);


  }

}
