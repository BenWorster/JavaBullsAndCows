/*
 * Ben Worster
 * Project06 - BullsAndCows
 * Due Date: 11/9/19
 * A class for storing and displaying Provng statistic
 *
 *              Revision History
 * ***************************************************************
 * 11/9/2019 - Finished the toString method and added Javadocs
 * 11/7/2019 - Created the Proving class. Added the unit test and wrote the
 *             parameterized contsrustor and the toString method.
               Added properties for the class.
 */
package bullsandcows;


public class Proving {
    
    //Properties
    private int birthMonth;
    private int birthDay;
    private int birthYear;
    private int daughters;
    private int records;
    private int avgMilk;
    private double avgButterfatPercentage;
    private double exImp;
    
    /**
     * Parameterized constructor for the Proving class
     * @param birthMonth
     * @param birthDay
     * @param birthYear
     * @param daughters
     * @param records
     * @param avgMilk
     * @param avgButterfatPercentage
     * @param exImp 
     */
    public Proving (int birthDay, int birthMonth, int birthYear,
            int daughters, int records, int avgMilk,
            double avgButterfatPercentage, double exImp){
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.daughters = daughters;
        this.records = records;
        this.avgMilk = avgMilk;
        this.avgButterfatPercentage = avgButterfatPercentage;
        this.exImp = exImp;
    } //End constructor method
    
    /**
     * Method formats our class into an easy to read string
     * @return a formatted string
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("Birth Date = %02d-%02d-%d", birthMonth,
                birthDay, birthYear));
        str.append("\nDaughter = ").append(daughters).append("\tRecords = ")
                .append(records);
        str.append("\nAvgMilk = ").append(avgMilk).append("  AvgBF% = ").append
                (avgButterfatPercentage).append("  AvgBF = ").append
                (((int)avgMilk * avgButterfatPercentage) / 100);
        str.append(String.format("\nExImp = %+.1f", exImp));
        return str.toString();
    } //End toString method
    
     /*
     * Unit Test for Proving. 
     * Run File to test it.
     */
    public static void main (String[] args){
        Proving proof1 = new Proving(6, 6, 1920, 93, 180, 15894, 3.4, -476.8);
        Proving proof2 = new Proving(6, 6, 1920, 93, 180, 15894, 3.4, 476.8);
        System.out.println(proof1);
        System.out.println();
        System.out.println(proof2);
    } //End unit test
} //End Proving class
