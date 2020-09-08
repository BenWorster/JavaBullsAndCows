/**
 * /**********************************************************************
 * REVISION HISTORY (newest first)
 * THIS CLASS IS FINISHED - DO NOT CHANGE
 **********************************************************************
 * 04/19/2017 - Anne Applin - added documentation
 * 2015 - David Briggs - original starting code
 *********************************************************************
 * Driver for the project. 
 * PLEASE NOTE:  Use Unit testing to test your classes and 
 * ignore the errors in this file until you have all classes 
 * working. 
 */
package bullsandcows;
import java.util.*;
import java.io.*;
/**
 * The driver for the Holstein-Fresian Pedigree application.
 * @author aapplin
 */
public class BullsAndCows {
    // Properties of the class
    private static Database herdBook;
    private String regNum;
    private String sireRegNum;
    private String damRegNum;
    private char gender;
    private int bMonth;
    private int bDay;
    private int bYear;
    private String name;
    private ClassificationScore cScore;
    private int month;
    private int day; 
    private int year;
    private int ga;
    private int dc;
    private int bc;
    private int ms;
    private Proving p;
    private int daughters;
    private int records;
    private int avgMilk;
    private double avgButterfatPercentage;
    private double exImp;
    LactationRecord r;
    private ArrayList <LactationRecord> lacRec;
    private int ageInYears;
    private int monthsAtCalving;
    private int daysInMilk;
    private int poundsInMilk;
    private double percentageButterfat;
    private int totalButterfat;
    /**
     * Displays a menu, asks for and reads a menu choice
     * This Method is complete - DO NOT CHANGE
     * @return an integer between 1 and 4 inclusive
     */
    public int getMenuChoice(){
        Scanner stdIn = new Scanner(System.in);
        int choice;
        do{
            System.out.print("*************************\n"
                           + "* 1. Print Pedigree     *\n"
                           + "* 2. Count Offspring    *\n"
                           + "* 3. Evaluate Offspring *\n"
                           + "* 4. Quit.              *\n"
                           + "*************************\n"
                           + "  Enter Choice --> ");
            choice = stdIn.nextInt();
        }while(choice < 1 || choice > 4);
        
        return choice;
    }

    /**
     *     YOU WRITE THIS ONE
     * Reads the input file and creates either a Bull or Cow
     * object and adds it to the Database
     * NOTE:
     * During development, we print out the full message of
     * the exception by using e.toString() and e.printStackTrace().
     * That is not recommended for production programs, since it 
     * gives hackers too much insight into the innards of the 
     * software, possibly allowing them to exploit it.Instead, 
     * production programs write error messages to internal 
     * log files that hackers wouldn't see.                 
     * @param h the Database object
     * @param fileName a String for the file that we want to 
     *                 use.
     */
    public void loadHerd(String fileName){
        Scanner s = null;
        try {
            while (s.hasNext()) {
                Animal a;
                regNum = s.next();
                sireRegNum = s.next();
                damRegNum = s.nextLine();
                gender = s.next().charAt(0);
                bMonth = s.nextInt();
                bDay = s.nextInt();
                bYear = s.nextInt();
                name = s.next();
                cScore = null;
                month = s.nextInt();
                if (month != -1){
                    day = s.nextInt();
                    year = s.nextInt();
                    ga = s.nextInt();
                    dc = s.nextInt();
                    bc = s.nextInt();
                    if (gender == 'm'){
                        cScore = new BullClassificationScore
                                (month, day, year, ga, dc, bc);
                    } else {
                        ms = s.nextInt();
                        cScore = new CowClassificationScore
                                (month, day, year, ga, dc, bc, ms);
                    }
                }
                if (gender == 'm'){
                    p = null;
                    month = s.nextInt();
                    if (month != -1){
                        day = s.nextInt();
                        year = s.nextInt();
                        daughters = s.nextInt();
                        records = s.nextInt();
                        avgMilk = s.nextInt();
                        avgButterfatPercentage = s.nextDouble();
                        exImp = s.nextDouble();
                        p = new Proving(month, day, year, daughters, records,
                        avgMilk, avgButterfatPercentage, exImp);
                    }
                    a = new Bull(regNum, sireRegNum, damRegNum, gender,
                        month, day, year, name, cScore, p);   
                } else {
                    lacRec = null;
                    ageInYears = s.nextInt();
                    if (ageInYears != -1){
                        lacRec = new ArrayList<>();
                    }
                    while (ageInYears != -1){
                        monthsAtCalving = s.nextInt();
                        daysInMilk = s.nextInt();
                        poundsInMilk = s.nextInt();
                        percentageButterfat = s.nextDouble();
                        totalButterfat = s.nextInt();
                        r = new LactationRecord(ageInYears,
                               monthsAtCalving, daysInMilk, poundsInMilk,
                               percentageButterfat);
                        lacRec.add(r);
                    }
                    a = new Cow(regNum, sireRegNum, damRegNum, gender,
                        month, day, year, name, cScore, lacRec);
                }
                herdBook.addToHerd(regNum, a);
            }
            
            // comment the next line out when you start on part 5!
            //System.out.println(herdBook.printHerd());
            s.close();
        } catch (InputMismatchException e) {
            System.out.println("Probably using nextInt or nextDouble"
                   + " when the file input is not of that type.");
            System.out.println(e);
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Probably some problem with the input"
                    + " data file or the keyboard input.");
            System.out.println(e);
            e.printStackTrace();
        }       
    }

    /**
     * Once your method in Database is written, comment out the last line
     * in this method and uncomment the one above it 
     * 
     *         Make no other changes.
     */
    public void printPedigree(){
        Scanner stdIn = new Scanner(System.in);
        
        System.out.print("Enter the registration number for the animal\n"
                       + "that you want the pedigree for: ");
        String regNum = stdIn.next();
        System.out.println(herdBook.printPedigree(regNum));
        //System.out.println("not yet implemented.");        
    }

    /**
     * Extra Credit 1 Method 
     * Once your method in Database is written, comment out the last line
     * in this method and uncomment the one above it
     * 
     *         Make no other changes.
     */
    public void countOffspring(){
        Scanner stdIn = new Scanner(System.in);
        System.out.print("Enter the registration number for the animal\n"
                       + "that you want the pedigree for: ");
        String regNum = stdIn.next();
        // System.out.println(herdbook.countOffspring(regNum);
        System.out.println("Not Implemented.");
    }

    /**
     * An Extra Credit 2 Method
     * Once your method in Database is written, comment out the last line
     * in this method and uncomment the one above it 
     * 
     *             Make no other changes.
     * 
     */
    public void evaluateOffspring(){
        Scanner stdIn = new Scanner(System.in);
        System.out.print("Enter the registration number for the animal\n"
                       + "that you want the pedigree for: ");
        String regNum = stdIn.next();
        // System.out.println(herdbook.evaluateOffspring(regNum);
        System.out.println("Not implemented.");
    }
    /**
     * The actual driver for the application
     * This method is DONE - DO NOT CHANGE THIS
     * @param fileName comes from the command line arguments
     */
    public void run(String fileName){
        boolean finished = false;
        // create an instance of the Database
        herdBook = new Database();
        loadHerd(fileName);
        while (!finished) {
            int choice = getMenuChoice();
            switch(choice){
                case 1: printPedigree();     break;
                case 2: countOffspring();    break;
                case 3: evaluateOffspring(); break;
                case 4: finished = true;
            }                
        }//end while  
    } // end run
    /**
     * This method is DONE DO NOT CHANGE THIS
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("usage: prog datafile");
            return;
        }
        // fileName from the command line arguments
        String fileName = args[0];        
        BullsAndCows driver = new BullsAndCows();
        driver.run(fileName);
    }
}
