/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements{

    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    /**
     * This is the modified constructor for a Cafe, where there are automatic values for a cafe...
     * It was not clear if I should customize values for the Cafe using parameters or set it myself in the constructor
     * @param name
     * @param address
     * @param nFloors
     */
    public Cafe(String name, String address, int nFloors) {
        super (name, address, nFloors);
        this.nCoffeeOunces = 100;
        this.nSugarPackets = 100;
        this.nCreams = 100;
        this.nCups = 100;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * This is overloaded Cafe with custom supplies values
     * @param name
     * @param address
     * @param nFloors
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    public Cafe (String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        super (name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * This sells a cup of coffee and allows the cafe to be restocked when materials are running low
     * @param size is the size of the coffee cup
     * @param nSugarPackets is the amount og sugar packets in the coffee
     * @param nCreams is the amount of cream packets in the coffee
     * @return void (nothing)
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){

        if (this.nCoffeeOunces==0||this.nSugarPackets== 0||this.nCreams==0||this.nCups==0){
            restock(100,100,100,30);
            //This may refill items even if they are not empty
        }

        this.nCoffeeOunces = this.nCoffeeOunces - size;
        this.nSugarPackets = this.nSugarPackets - nSugarPackets;
        this.nCreams = this.nCreams - nCreams;
        this.nCups = nCups - 1;
    }

    /**
     * This sells a cup of coffee and allows the cafe to be restocked when materials are running low
     * This is an overloaded version
     * @param size is the size of the coffee cup
     * @return void (nothing)
     */
    public void sellCoffee (int size){
        if (this.nCoffeeOunces==0||this.nSugarPackets== 0||this.nCreams==0||this.nCups==0){
            restock(100,100,100,30);
            //This may refill items even if they are not empty
        }
        System.out.println("You will recieve a default coffee cup");
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= 3; 
        this.nCreams -= 2;
        this.nCups -=1;
    }

    /**
     * This restocks the Cafe, and is called within sellCoffee
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     * @return void
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    /**
     * This shows the options of methods in the cafe subclass
     * @return void
     */
    public void showOptions() {
        super.showOptions();
        System.out.println("Other available options at " + this.name + ":\n + sellCoffee(size, nSugarPackets, nCreams) \n + restock(size, nSugarPackets, nCreams, nCups) \n");
    }

    /**
     * This allows someone to go to a floor using an elevator, but cafe's cannot change floors
     * @param floorNum the number of floor to go to
     * @return void
     */
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        
        if (floorNum != 1) {
            throw new RuntimeException("Invalid floor number. This is only for employees");
        } else {
            System.out.println ("You will remain on the first floor");
        }
    }
    
    public static void main(String[] args) {
        Cafe myCafe = new Cafe("CC Cafe", "Green Street", 1);
        myCafe.sellCoffee(12,3,4);
        myCafe.sellCoffee(16);
        System.out.println(myCafe.nCoffeeOunces+" "+myCafe.nSugarPackets+" "+myCafe.nCreams+" "+myCafe.nCups);
        //this testing works!
        myCafe.showOptions();
        myCafe.enter();
        myCafe.goToFloor(1);
    }
}
