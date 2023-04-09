public class Cafe extends Building {

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
 * Constructs a Cafe
 *
 * @param name
 * @param address
 * @param nFloors
 */

    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        System.out.println("You have built a cafe: ☕");
        nCoffeeOunces = 600;
        nSugarPackets = 100;
        nCreams = 100;
        nCups = 80;

    }

    /**
 * Constructs a Cafe
 *
 * @param name
 * @param address
 * @param nFloors
 * @param hasOutdoorSeating
 */

    public Cafe(String name, String address, int nFloors, boolean hasOutdoorSeating) {
        super(name, address, nFloors);
        System.out.println("You have built a cafe: ☕");
        nCoffeeOunces = 600;
        nSugarPackets = 100;
        nCreams = 100;
        nCups = 80;

    }

    /**
 * Sells a coffee and triggers the restock method if there are not enough ingredients for the drink
 *
 * @param size
 * @param sugars
 * @param creams
 */

    public void sellCoffee(int size, int sugars, int creams) {
        if (size > 600 || sugars > 100 || creams > 100) {
            System.out.println("We never stock more than 600 ounces of coffee, 100 sugar packets, and 100 creams. Please make sure your order is within the bounds of our supply.");
        } else {
            if (nCoffeeOunces >= size && nSugarPackets >= sugars && nCreams >= creams && nCups >= 1) {
                nCoffeeOunces = nCoffeeOunces - size; 
                nSugarPackets = nSugarPackets - sugars; 
                nCreams = nCreams - creams;
                nCups = nCups - 1;
                System.out.println("Your order: " + size + " ounce(s), " + sugars + " sugar(s), " + creams + " cream(s)");
                System.out.println("Remaining stock: " + nCoffeeOunces + " ounce(s) of coffee, " + nSugarPackets + " sugar(s), " + nCreams + " cream(s), " + nCups + " cup(s)");
            } else {
                restock(size, sugars, creams, nCups);
            }
        }
    }

     /**
 * Converts the size to ounces and calls the other sellCoffee() method
 *
 * @param size
 * @param sugars
 * @param creams
 */

    public void sellCoffee(String size, int sugars, int creams) {
        if (size.equals("s")) {
            sellCoffee(12, sugars, creams);
        }
        else if (size.equals("m")) {
            sellCoffee(16, sugars, creams);
        }
        else if (size.equals("l")) {
            sellCoffee(24, sugars, creams);
        }
        else {
            System.out.println("Please select a valid size.");
        }
    }

    /**
 * Restocks all supplies that are too low to make the requested drink and triggers the sell method when finished
 *
 * @param size
 * @param sugars
 * @param creams
 * @param nCups
 */

    private void restock(int size, int sugars, int creams, int nCups) {
        System.out.println("Restocking items...");
        if (nCoffeeOunces < size) {
            nCoffeeOunces = 600; 
        }
        if (nSugarPackets < sugars) {
            nSugarPackets = 100;
        } 
        if (nCreams < creams) {
            nCreams = 100;
        } 
        if (nCups < 1) {
            nCups = 80;
        }
        System.out.println("Restock complete. Your order will now be completed."); 
        sellCoffee(size, sugars, creams); 
    }

    /**
 * Prints options of how to interact with the cafe.
 */    

    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + sellCoffee(size, sugars, creams) \n     -You can enter a size in ounces or as 's' (small), 'm' (medium), or 'l' (large)");
    }

    /**
 * Throws exception telling the user that this method doesn't apply to the cafe Class
 */ 

    public void goToFloor(int floorNum) {
        throw new RuntimeException(this.name + " only has 1 floor available to costumers. You cannot change floors.");
        }
    
/**
 * Creates an instance of the Cafe class
 *
 * @param args The command line arguments (ignored)
 */

    public static void main(String[] args) {

        Cafe sweetPea = new Cafe("Sweet Pea Cafe", "144 Flores Blvd", 1);
        System.out.println(sweetPea);
        //    Testing:
        // sweetPea.showOptions();
        // sweetPea.sellCoffee("s", 2, 2);
        // sweetPea.sellCoffee(8, 100, 4);
        // sweetPea.enter();
        // sweetPea.goUp();
        
        



    }
    
}

