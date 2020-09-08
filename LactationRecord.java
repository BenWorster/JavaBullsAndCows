/*
 * Ben Worster
 * Project06 - BullsAndCows
 * Due Date: 11/9/19
 * A class for storing and displaying Lactation records
 *
 *              Revision History
 * ***************************************************************
 * 11/9/2019 - Finished the toString method and added Javadocs
 * 11/7/2019 - Created the LactaionRecord class. Added the unit test and wrote
 *             the parameterized contsrustor and the toString method.
 */
package bullsandcows;

import java.util.ArrayList;

public class LactationRecord {
    
    //Properties
    private int ageInYears;
    private int monthsAtCalving;
    private int daysInMilk;
    private int poundsInMilk;
    private double percentageButterfat;
    private int totalButterfat;
    
    /**
     * Parameterized constructor for the LactationRecord class
     * @param ageInYears
     * @param monthsAtCalving
     * @param daysInMilk
     * @param poundsInMilk
     * @param percentageButterfat 
     */
    public LactationRecord (int ageInYears, int monthsAtCalving, int daysInMilk,
            int poundsInMilk, double percentageButterfat){
        this.ageInYears = ageInYears;
        this.monthsAtCalving = monthsAtCalving;
        this.daysInMilk = daysInMilk;
        this.poundsInMilk = poundsInMilk;
        this.percentageButterfat = percentageButterfat;
        //Method calls
        calcButterfat();    
    } //End constructor method
    
    /**
     * Method for calculating the total pounds of butterfat from
     * a selected cow.
     */
    public void calcButterfat(){
        //Calculate total butterfat in pounds
        totalButterfat = (int)(poundsInMilk * percentageButterfat) / 100;
    }
    
    /**
     * Method formats our class into an easy to read string
     * @return a formatted string
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("%2d-%2d   %d   %6d   %4.1f   %4d",
                ageInYears, monthsAtCalving, daysInMilk, poundsInMilk,
                percentageButterfat, totalButterfat));
        return str.toString();
    } //End toString method
    
    /**
     * Unit Test for LactationRecord.
     * Run File to test it.
     */
     public static void main(String[] args){
        ArrayList<LactationRecord> lacRecs = new ArrayList<>();
        lacRecs.add(new LactationRecord(2, 10, 228, 17232, 5.3));
        lacRecs.add(new LactationRecord(3, 2, 178, 3290, 4.0));
        lacRecs.add(new LactationRecord(4, 5, 260, 266, 3.2));
        System.out.println("Milk Records");
        for(LactationRecord record: lacRecs){
            System.out.println(record);
        }
    } // end Unit Test
} //End LactaionRecord class
