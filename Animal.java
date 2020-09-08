/*
 * Ben Worster
 * Project06 - BullsAndCows
 * Due Date: 11/16/19
 * A class for holding statistics and properties shared
 * by bulls and cow.
 *
 *              Revision History
 * ***************************************************************
 * 11/15/2019 - Wrote the toString method and added Javadocs
 * 11/11/2019 - Added properties, wrote the constructor and unit test.  
 *              Wrote the getters for the dam and sire registration numbers.
 */
package bullsandcows;

import java.util.ArrayList;

public abstract class Animal {
    
    //Properties
    protected String regNumber;
    protected String sireRegNumber;
    protected String damRegNumber;
    protected char gender;
    protected int birthMonth;
    protected int birthDay;
    protected int birthYear;
    protected String name;
    protected ClassificationScore score;
    
    /**
     * Parameterized constructor for the Animal Class
     * @param regNumber
     * @param sireRegNumber
     * @param damRegNumber
     * @param gender
     * @param birthMonth
     * @param birthDay
     * @param birthYear
     * @param name 
     * @param score 
     */
    public Animal(String regNumber, String sireRegNumber, String damRegNumber,
            char gender, int birthMonth, int birthDay, int birthYear, 
            String name, ClassificationScore score){
        this.regNumber = regNumber;
        this.sireRegNumber = sireRegNumber;
        this.damRegNumber = damRegNumber;
        this.gender = gender;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.birthYear = birthYear;
        this.name = name;
        this.score = score;
    } //End constructor method
    
    /**
     * Access for sire registration number
     * @return 
     */
    public String getSireRegNumber(){
        return sireRegNumber;
    } //End getSireRegNumber method
    
    /**
     * Access for dam registration number
     * @return 
     */
    public String getDamRegNumber(){
        return damRegNumber;
    } //End getDamRegNumber method
    
    /**
     * Method formats our class into an easy to read string
     * @return a formatted string
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Registration number: ").append(regNumber);
        str.append("\nName: ").append(name);
        str.append(String.format("Birth Date = %02d-%02d-%d", birthMonth,
                birthDay, birthYear));
        if (score == null){
            str.append("\nClassification: N/A");
        } else {
            str.append("\nClassification: ").append(score);
        }
        return str.toString();
    } //End toString method

    /**
     * Unit Tester for Animal, Cow and Bull. Run file to test both Cow and Bull.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        ClassificationScore 
                perfectCow = new CowClassificationScore(1, 2, 2010, 30, 20, 20, 30),
                nullCow = null,
                perfectBull = new BullClassificationScore(5, 6, 2012, 40, 30, 30),
                nullBull = null;

        Proving noProving = null,
                proving = new Proving(6, 4, 2016, 20, 200,
                        1500, 3.25, 324);
        ArrayList<LactationRecord> empty = null;
        ArrayList<LactationRecord> lacRecs = new ArrayList<>();
        lacRecs.add(new LactationRecord(2, 10, 228, 17232, 5.3));
        lacRecs.add(new LactationRecord(3, 2, 178, 3290, 4.0));
        lacRecs.add(new LactationRecord(4, 3, 260, 266, 3.2));
        Animal bull1 = new Bull("0001", "0002", "0003", 'm', 4, 8, 2000,
                "aBull", perfectBull, noProving);
        Animal bull2 = new Bull("0001", "0002", "0003", 'm', 4, 8, 2000,
                "anotherBull", nullBull, proving);
        Animal cow1 = new Cow("0001", "0002", "0003", 'f', 4, 8, 2000,
                "aCow", perfectCow, empty);
        Animal cow2 = new Cow("0001", "0002", "0003", 'f', 4, 8, 2000,
                "anotherCow", nullCow, lacRecs);
        System.out.println(bull1);
        System.out.println();
        System.out.println(bull2);
        System.out.println();
        System.out.println(cow1);
        System.out.println();
        System.out.println(cow2);
    } //End main method
} //End Animal class
