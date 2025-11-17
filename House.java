/* This is a stub for the House class */

import java.util.ArrayList;

public class House extends Building implements HouseRequirements{

  private ArrayList<Student> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;

  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    this.residents = new ArrayList<Student>();
    System.out.println("You have built a house: 🏠");
  }

  /**
   * This is an overloaded version of the constructor, automatically giving a house no dining hall or elevator
   * @param name
   * @param address
   * @param nFloors
   */
  public House (String name, String address, int nFloors){
    this (name, address, nFloors, false, false);
  }

  /**
   * This determines if a house has a dining room
   * @return T/F: Does a house have a dining room?
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  /**
   * This determines if a house has a dining room
   * @return int: Number of students in a house?
   */
  public int nResidents(){
    return residents.size(); 
  }

  /**
   * This moves a student into a house
   * @param s which is a particular student
   */
  public void moveIn(Student s){
    if (residents.contains(s)){
      System.out.println("This Student is already in the house");
    }
    else{
      residents.add(s);
      System.out.println("This student has been added to the house");
    }
  }

  /**
   * This moves a student out of a house 
   * @param s which is a particular student
   * @return Student which is a certain student
   */
  public Student moveOut(Student s){

    if (residents.contains(s)){
      residents.remove(s);
      return s;
    }
    else{
      System.out.println("This person cannot move out since they were never in the house");
      return s;
    }
  }

  /**
   * Determines if a student is a resident of a certain house
   * @param s which is a particular student
   * @return T/F: Is this student in this house?
   */
  public boolean isResident(Student s){
    if (residents.contains(s)){
      System.out.println("This student is in this house");
      return true;
    }
    else{
      System.out.println("This student is NOT in this house");
      return false;
    }
  }

  /**
   * This is the overloaded version of isResident using a name instead of Student type to see if someone is in a House
   * @param name : of student
   * @return T/F
   */
  public boolean isResident (String name){
    for (Student currentStudent : residents){
      if (currentStudent.getName().equals(name)){
        System.out.println("This person " +name+ " is in this house");
        return true;
      }
    }
    System.out.println("This person " +name+ " is not in this house");
    return false;
  }

  /**
   * This prints the methods available in the House class
   */
  public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + hasDiningRoom() \n + nResidents() \n + moveIn(s) \n + moveOut(s)\n + isResident(s)");
        //I did not add the data types of the parameters since the Building class did not add 'int' before n (the parameter)
  }

  /**
   * This allows you to automatically change floors, with or without an elevator
   * @param floorNum the floor you wish to go to
   */
  public void goToFloor(int floorNum) {
    if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
    }
    if (this.nFloors - floorNum > 1 || floorNum - this.nFloors > 1){
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
    Student newStudent = new Student ("Cathy", "300009", 2029);
    House newHouse = new House ("Lamont", "17 Prospect Street", 5, true, true);
    //new House();
    newHouse.moveIn(newStudent);
    System.out.println(newHouse.hasDiningRoom());
    System.out.println(newHouse.nResidents());
    //This testing has worked!!
    newHouse.showOptions();
    newHouse.enter();
    newHouse.goUp();
  }
}