/*
 * Ben Worster
 * Project06 - BullsAndCows
 * Due Date: 11/23/19
 * A class for holding statistics and properties for Cows
 *
 *              Revision History
 * ***************************************************************
 * 11/22/2019 - 
 * 11/20/2019 - Created Cow class and added the property. Wrote the 
 *              parameterized constructor and started the toString method.
 */
package bullsandcows;

import java.util.ArrayList;

public class Cow extends Animal {
    
    //Properties
    protected ArrayList<LactationRecord> lacRec = new ArrayList<>();
    
    /**
     * Parameterized constructor for the Cow class
     * 
     * @param regNumber
     * @param sireRegNumber
     * @param damRegNumber
     * @param gender
     * @param birthMonth
     * @param birthDay
     * @param birthYear
     * @param name
     * @param score
     * @param lacRec 
     */
    public Cow(String regNumber, String sireRegNumber, String damRegNumber,
            char gender, int birthMonth, int birthDay, int birthYear,
            String name, ClassificationScore score,
            ArrayList<LactationRecord> lacRec) {
        super(regNumber, sireRegNumber, damRegNumber, gender,
                birthMonth, birthDay, birthYear, name, score);
        this.lacRec = lacRec;
    }
    
    /**
     * Method formats our class into an easy to read string
     * @return a formatted string
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(super.toString());
        if (lacRec == null){
            str.append("\nNo Milk Records");
        } else {
            str.append("\nMilk Records: ");
            for (int i = 0; i<lacRec.size(); i++){
                str.append("\n").append(lacRec.get(i));
            }
        }
        return str.toString();
    } //End toString method
    
}
