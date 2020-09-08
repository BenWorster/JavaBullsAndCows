/*
 * Ben Worster
 * Project06 - BullsAndCows
 * Due Date: 11//19
 * A class for holding a database of Bulls and Cows
 *
 *              Revision History
 * ***************************************************************
 * 11/30/2019 - 
 * 11/27/2019 - Added the treemap property. Wrote the constructor and 
 *              started the addtoHerd and printHerd methods.
 */
package bullsandcows;

import java.util.TreeMap;

/**
 * Database of cows.  
 * @author Ben Worster
 */
public class Database {
    
    //Properties
    TreeMap<String, Animal> database;
    
    /**
     * Constructor for the database class
     */
    public Database(){
        database = new TreeMap<>();
    }
    
    /**
     * Method that takes in a registration number and an animal object and
     * adds it to the herd.
     * @param regNum
     * @param a 
     */
    public void addToHerd(String regNum, Animal a){
       database.put(regNum, a);
    }
    
    /**
     * This method is for debugging part 4.  
     * You should iterate through your map to generate the output String
     * Look at BookStoreMap for an example of iterating over a map.  
     * @return a string that is the output of the entire herd as long as the
     *  herd isn't more than 13 animals.
     */
    public String printHerd(){
        StringBuilder str = new StringBuilder();
        for (Animal a : database.values()){
                str.append(a.toString()).append("\n");
        }
        return str.toString();
    }
    /**
     * Method to create a string that represents 2 generations of an animal's
     * ancestry.  If the Animal exists in the database, it is printed.  If
     * its dam is present it is printed as are the dam's parents if they 
     * exist.  If its sire is present it is printed as are the sire's 
     * parents if they exist.
     * @param regNum the registration number of the animal to evaluate
     * @return a two generation pedigree of the input animal if it exists
     *      or a string that says it does not exist.
     */
    public String printPedigree(String regNum){
        StringBuilder str = new StringBuilder();
        String eol = "\n";
        str.append("Data for the animal:").append(eol);
        //Check to see if the animal is in the database
        if (database.containsKey(regNum)){
            Animal a = database.get(regNum);
            str.append(a.toString()).append(eol);
            str.append("Data for Dam:").append(eol);
            //Check animals Dam
            if (database.containsKey(a.getDamRegNumber())){
                Animal dam = database.get(a.getDamRegNumber());
                str.append(dam.toString()).append(eol);
                str.append("Data for Maternal Granddam:").append(eol);
                //Check maternal Granddam
                if (database.containsKey(dam.getDamRegNumber())){
                    Animal maternalGranddam = database.get(dam.getDamRegNumber());
                    str.append(maternalGranddam.toString()).append(eol);
                } else {
                    str.append("n/a").append(eol);
                }
                str.append("Data for Maternal Grandsire:").append(eol);
                //Check maternal Grandsire
                if (database.containsKey(dam.getSireRegNumber())){
                    Animal maternalGrandsire = database.get(dam.getSireRegNumber());
                    str.append(maternalGrandsire.toString()).append(eol);
                } else {
                    str.append("n/a").append(eol);
                }
            } else {
                str.append("n/a").append(eol);
            }
            str.append("Data for Sire:").append(eol);
            //Check animals Sire
            if (database.containsKey(a.getSireRegNumber())){
                Animal sire = database.get(a.getSireRegNumber());
                str.append(sire.toString()).append(eol);
                str.append("Data for Paternal Granddam:");
                //Check paternal Granddam
                if (database.containsKey(sire.getDamRegNumber())){
                    Animal paternalGranddam = database.get(sire.getDamRegNumber());
                    str.append(paternalGranddam.toString()).append(eol);
                } else {
                    str.append("n/a").append(eol);
                }
                str.append("Data for Paternal Grandsire:");
                //Check maternal Grandsire
                if (database.containsKey(sire.getSireRegNumber())){
                    Animal paternalGrandsire = database.get(sire.getSireRegNumber());
                    str.append(paternalGrandsire.toString()).append(eol);
                } else {
                    str.append("n/a").append(eol);
                }
            } else {
                str.append ("n/a").append(eol);
            }
            
        } else {
            str.append("Animal does not exist in the database");
        }
        
        return str.toString();
    }
    /**
     *    EXTRA CREDIT 1
     * if you implement this, then change these comments and complete
     * the JavaDoc otherwise leave it ALL alone
     * @param regNum the registration number of the animal to evaluate
     * @return 
     */
    public String countOffspring(String regNum){
        return "Not yet implemented.";
    }
    /**
     *    EXTRA CREDIT 2
     * if you implement this, then change these comments and complete
     * the JavaDoc otherwise leave it ALL alone
     * @param regNum the registration number of the animal to evaluate
     * @return 
     */
    public String evaluateOffspring(String regNum){
        return "Not yet implemented.";
    }
}
