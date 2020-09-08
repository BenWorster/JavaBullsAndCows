/*
 * Ben Worster
 * Project06 - BullsAndCows
 * Due Date: 11/23/19
 * A class for holding statistics and properties for Bulls
 *
 *              Revision History
 * ***************************************************************
 * 11/22/2019 - 
 * 11/20/2019 - Created Bull class and added the property. Wrote the 
 *              parameterized constructor and started the toString method.
 */
package bullsandcows;

public class Bull extends Animal {
    
    //Properties
    protected Proving proving;
    
    /**
     * Parameterized constructor for the Bull class
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
     * @param proving 
     */
    public Bull(String regNumber, String sireRegNumber, String damRegNumber,
            char gender, int birthMonth, int birthDay, int birthYear,
            String name, ClassificationScore score, Proving proving) {
        super(regNumber, sireRegNumber, damRegNumber, gender,
                birthMonth, birthDay, birthYear, name, score);
        this.proving = proving;
    }
    
    /**
     * Method formats our class into an easy to read string
     * @return a formatted string
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(super.toString());
        if (proving == null){
            str.append("\nProving: N/A");
        } else {
            str.append("\nProving: ").append(proving);
        }
        return str.toString();
    } //End toString method
    
}
