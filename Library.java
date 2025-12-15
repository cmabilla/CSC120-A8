/* This is a stub for the Library class */

import java.util.Hashtable;

public class Library extends Building implements LibraryRequirements {

  private Hashtable<String, Boolean> collection;
  private boolean hasElevator;

  /**
   * This is the main constructor of Library
   * @param name
   * @param address
   * @param nFloors
   * @param hasElevator
   */
    public Library(String name, String address, int nFloors, boolean hasElevator) {
      super (name, address, nFloors);
      this.hasElevator = hasElevator;
      this.collection = new Hashtable <String, Boolean>();
      System.out.println("You have built a library: 📖");
    }

    /**
     * This is a constructor where all attributes are given a default value
     * Overloading
     * No parameters or return values available
     */
    public Library (){
      this ("Smith College Library", "Northampton MA", 2, false);
    }

    /**
     * This constructor is only giving a parameter name, and the rest are set to a default value
     * Overloading
     * @param name
     */
    public Library (String name){
      this (name, "Northampton MA 01063", 2, false);
    }

    /**
     * This adds a book to a librarys catalogue
     * @param title which is the book title 
     */
    public void addTitle(String title){
      if (collection.containsKey(title)){
        System.out.println("Sorry this title is already in the collection");
      } else {
        collection.put(title, true);
        System.out.println(title + " is now in the collection");
        //this title is now in the collection and it is 'true'
      }
    }

    /**
     * This removes a book from a library catalog
     * @param title which is the book title 
     * @return String which is the book name being removed
     */
    public String removeTitle(String title){
      if (collection.containsKey(title)){
        collection.remove(title);
        //Online tutorial says you only need to provide the key in 'remove'
        return title;
      } else {
        return ("This title was never in the collection!");
      }
    }

    /**
     * Checks out a library book 
     * @param title which is the book title
     */
    public void checkOut(String title){
      collection.replace(title, false);
      System.out.println("This book " + title + " has been checked out.");
    }

    /**
     * This is the overloaded version of checkOut, which intakes the book name and returndate
     * @param title
     * @param returnDate
     */
    public void checkOut (String title, String returnDate){
      collection.replace (title,false);
      System.out.println("This book" +title+ " must be returned by " +returnDate);
    }
    

    /**
     * Returns a library book
     * @param title which is the book title 
     */
    public void returnBook(String title){
      collection.replace(title,true);
      System.out.println("This book as been returned to the Library collection");
    }

    /**
     * This method sees if the library has a certain book
     * @param title which is the book title being looked for
     * @return T/F: does the library have this book?
     */
    public boolean containsTitle(String title){
      if (collection.containsKey(title)){
        System.out.println("This title is in the Library");
        return true;
      } else {
        System.out.println("This title is NOT in the Library");
        return false;
      }
    }

    /**
     * Sees if a certain book is available in the library
     * @param title which is the book title being looked for
     * @return T/F: Is the book available?
     */
    public boolean isAvailable(String title){
      boolean availability;
      availability = collection.get(title);
      //Found this method on geeks for geeks
      //also the if statement is redundant but its assuring
      if (availability == true){
        return true;
      } else {
        return false;
      }
    }

    /**
     * This prints the hashtable 'collection'
     */
    public void printCollection(){
      //I also found entrySet but that confused me
      //I found toString method on G4G but thats all on one line and I am unsure how to print it on separate lines
      System.out.println(collection.toString());
    }

    /**
     * This shows all of the available methods in Library
     */
    public void showOptions() {
      super.showOptions();
      System.out.println("Other available options at " + this.name + ":\n + addTitle(t) \n + removeTitle(t) \n + checkOut(t) \n + returnBook(t)\n + containsTitle(t) \n + isAvailable(t) \n + printCollection() \n ");
    }

    /**
     * This allows moving between floors using an elevator or not
     * @param floorNum the floor that you intend to move to
     */
    public void goToFloor(int floorNum) {
      if (this.activeFloor == -1) {
          throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
      }

      if (floorNum < 1 || floorNum > this.nFloors) {
          throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
      }
      
      if (this.activeFloor - floorNum > 1 || floorNum - this.activeFloor > 1){
        if (this.hasElevator){
          System.out.println("You are now on floor #" + floorNum + " of " + this.name);
          this.activeFloor = floorNum;
        } else {
          throw new RuntimeException("There is no elevator in this building");
        }
      } else {
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
      }
    }
  
    public static void main(String[] args) {
      Library myLibrary = new Library("Neilson", "Elm Street", 6, true);
      myLibrary.addTitle("Narnia");
      myLibrary.addTitle("Cat in the Hat");
      System.out.println(myLibrary.removeTitle("Harry Potter"));
      myLibrary.checkOut("Narnia");
      myLibrary.returnBook("Narnia");
      myLibrary.isAvailable("Cat in the Hat");
      myLibrary.printCollection();
      //This testing has worked!!
      myLibrary.showOptions();
    }
  
  }