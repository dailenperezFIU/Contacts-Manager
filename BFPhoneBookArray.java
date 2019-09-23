/**  * 
 * @author (5760414) *
 *  Title:            (Best Friends Phonebook Using Array)*
 * Semester:         COP3337 - Fall 2018*
 * Lecturer's Name:  (Charters)*
 * Description of Program’s Functionality:
 *   Program allows user to save , delete , update and display contacts in a 
 * phone book which is really an array of friends..** 
 */ 
package bfphonebookarray;
import java.util.Scanner;


public class BFPhoneBookArray {
    /** instantiates helper object scanner to be able to read user input and calla appropriate methods respectively **/
    BFFHelper helper = new BFFHelper();
    static Scanner scan = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
         // Initializes phoneBook object for easier calling.
        // loops display menu of user's options while using the phonebook while 
        //they don't input option 5 which is the exit option.
    
   
          int userOption;
   
       BFPhoneBookArray phoneBook = new BFPhoneBookArray();
       do{
           phoneBook.displayMenu();
           userOption = scan.nextInt();
           phoneBook.userChoice(userOption);
         
       }while(userOption!=5);
       
       
    }
    
    // Displays Menu of the user's options while using the phonebook
    public void displayMenu(){
        System.out.println("\n1. Add a best friend to your phonebook");
        System.out.println("2. Change contact information of a best friend");
        System.out.println("3. Remove a BestFriend ");
        System.out.println("4. Display friend/s");
        System.out.println("5. Exit");
        System.out.println("\nEnter the number of what you'd like to do.");
     
    }
    /**@param userOption   the integer entered by user. 
     * Its used to display the method of the number they chose **/
    
    public void userChoice(int userOption){

             
        switch(userOption){
            case 1:
                helper.addFriend();
                break;
            case 2:
                helper.changeFriend();
                break;
            case 3:
                helper.removeFriend();
                break;
            case 4:
                helper.displayFriend();
                break;
            case 5:
                System.out.println("GoodBye!");
                break;
            default:
                 System.out.println("\nThe number you entered was not an option.\n"
                         + "Enter 5 to exit or type a valid option.");
        }
 
}
}
