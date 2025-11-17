import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        //Full constructor
        //Building 1

        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063"));
        //Overloaded constructor
        //Building 2

        House talbot = new House ("Talbot House","25 Prospect Street Northampton, MA 01063", 5 );
        myMap.addBuilding(talbot);
        Student myStudent2 = new Student ("Katherine", "2300000", 2029);
        talbot.moveIn(myStudent2);
        System.out.println(talbot.isResident("katherine"));
        //This tests the new Movein
        //Building 3

        myMap.addBuilding(new House("Capen House","26 Prospect Street Northampton, MA 01063", 3, false, false));
        //This tests the overloaded constructor
        //Building 4
        
        House lamont = new House ("Lamont House","17 Prospect Street Northampton, MA 01063", 5 );
        myMap.addBuilding(lamont);
        Student myStudent = new Student ("Catherine", "2300000", 2029);
        lamont.moveIn(myStudent);
        System.out.println(lamont.isResident("Catherine"));
        //this tests the overloaded 'isResident'
        //Building 5

        Cafe campusCenter = new Cafe ("Campus Center Cafe", "Elm Street", 3, 200, 300, 150, 270);
        myMap.addBuilding(campusCenter); 
        campusCenter.toString();
        //This tests the new Cafe constructor meaning that you decide the amount of supplies
        //Building 6

        campusCenter.sellCoffee(16);
        //This sells a default Coffee Type depending on the size of coffee the request

        Cafe compass = new Cafe ("Compass Cafe", "Green Street", 1);
        myMap.addBuilding(compass); 
        campusCenter.toString();
        //Original constructor
        //Building 7

        compass.sellCoffee(12);
        //tests the new sell coffee

        Library artLibrary1 = new Library();
        Library artLibrary2 = new Library ("Hillyer Art Library");
        myMap.addBuilding(artLibrary1);//Building 6
        myMap.addBuilding(artLibrary2);//Building 11
        artLibrary1.toString();
        artLibrary2.toString();
        //tests the modified constructors

        Library josten = new Library ("Josten Library","Northampton MA 01063", 2, false );
        myMap.addBuilding(josten); 
        josten.addTitle("Narnia");
        josten.checkOut("Narnia", "30th May");
        //Building 9 

        Library neilson = new Library ("Neilson Library","Northampton MA 01063", 5, true );
        myMap.addBuilding(neilson); 
        neilson.addTitle("Harry Potter");
        neilson.checkOut("Harry Potter", "10th August");
        //Building 10

        System.out.println(myMap);
        
    }
    
}
