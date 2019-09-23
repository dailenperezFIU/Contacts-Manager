/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfphonebookarray;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dailenperez
 */
public class BFFHelper {

     // instantiates myBFF array , scanner for user input
    //and index as a global variable for easier access to the index found by search method
    // also a current size variable to be able to expand or contract my array 
    private BFF[] myBFFs;

    private Scanner scan;
    private int index;
    private int currentSize = 0;

    // BFFHelper constructor
    public BFFHelper() {

        myBFFs = new BFF[10];
        scan = new Scanner(System.in);

    }
  /**  asks user questions to be able to see if the friend they want to change 
     * exists in the phone book .
    If it does then more questions are asked to update the information . If it 
    * doesn't then the search method called prints friend not found and changeFriend
    * method takes no action **/
    public void changeFriend() {
        System.out.println("Answer the following questions on your friend's current contact information:\n ");
        searchFriend();

        if (index > -1) {

            System.out.println("Answer the following questions to update their information:\n");
            System.out.println("Enter the first name you want them to appear under in your phonebook");
            String firstName = scan.nextLine();
            System.out.println("Enter their updated last name");
            String lastName = scan.nextLine();
            System.out.println("Enter their updated nick name");
            String nickName = scan.nextLine();
            System.out.println("Enter their updated phone number");
            String cellPhone = scan.nextLine();
            System.out.println("Enter their updated email");
            String email = scan.nextLine();
            BFF updatedBFF = new BFF(firstName, lastName, nickName, cellPhone, email);
            myBFFs[index] = updatedBFF;
            System.out.println("Friend changed");
        }

    }
/** Method asks questions , then passes their answer as parameter to create a 
    best friend object and add it to the phone book(myBFFs)**/
    public void addFriend() {
//        
        System.out.println("Answer the following questions to add a friend  to "
                + "your phonebook:\n");

        System.out.println("Enter the first name of the friend you'd like to add");
        String firstName = scan.nextLine();
        System.out.println("Enter the last name of the friend you'd like to add");
        String lastName = scan.nextLine();
        System.out.println("Enter the nick-name of the friend you'd like to add");
        String nickName = scan.nextLine();
        System.out.println("Enter the cellPhone of the friend you'd like to add");
        String cellPhone = scan.nextLine();
        System.out.println("Enter the email of the friend you'd like to add");
        String email = scan.nextLine();

        BFF aBFF = new BFF(firstName, lastName, nickName, cellPhone, email);

        if (currentSize < myBFFs.length) {
            myBFFs[currentSize] = aBFF;
            currentSize++;
             System.out.println("Friend Added");

        }
        if (currentSize >= myBFFs.length) {

            BFF[] temp = new BFF[myBFFs.length * 2];

            for (int i = 0; i < currentSize; i++) {
                temp[i] = myBFFs[i];
            }

            myBFFs = temp;
            myBFFs[currentSize] = aBFF;
            currentSize++;
            System.out.println("Friend Added");
        }

        
    }

    /** calls search method which finds friend they want to remove . If the friend
 * was found then it'll remove it and say friend removed  **/
    public void removeFriend() {
        searchFriend();

        if (index > -1) {

            if (index == currentSize - 1) {
                myBFFs[index] = null;
            }
            else {
                myBFFs[index]= myBFFs[index+1];
            
            }
           myBFFs[currentSize-1]= null;
           currentSize--;
            System.out.println("Friend Removed.");
        }
        

    }
 /** Asks user if they would like to display all friends or only a specific one.
     * If all is chosen it prints out entire array .If specific friend was chosen
     * it prints out that friend but only if * it was found by search method. If
     * an invalid option wad picked it'll state it and then go back to main menu**/
    public void displayFriend() {
        int displayNum;
        System.out.println("\nEnter: "
                + "\n 1) if you would like to display a specific friend."
                + "\n 2) if you'd like to display them all.");
        displayNum = scan.nextInt();
        scan.nextLine();

        if (displayNum == 1) {

            searchFriend();

            if ((index > -1)) {

                System.out.println(myBFFs[index]);

            }

        } else if (displayNum == 2) {
             // for loop for array but not with length it'll be with current size

            for (int i = 0; i < currentSize; i++) {
                System.out.println(myBFFs[i]);
            }

        } else {
            System.out.println("Invalid input");
        }

    }

    /** Asks questions to be able to use BFF class overloaded constructor to search
 * for a friend. While the arrayList still has elements and the elements are of type BFF 
 , the code will look through each of its indexes to find the friend they requested.
 * If its found it will store that index in variable index. If the whole array has been looked
 * through and friend wasn't found method gives variable index -1 value  ends and prints friend not found.**/
    public void searchFriend() {

        System.out.println("Enter the first name of the friend ");

        String firstName = scan.nextLine();
        System.out.println("Enter the last name of the friend ");
        String lastName = scan.nextLine();
        System.out.println("Enter the nick-name of the friend ");
        String nickName = scan.nextLine();

        int i = 0;
        BFF searcher = new BFF(firstName, lastName, nickName);

        while (!searcher.equals(myBFFs[i]) && (i < myBFFs.length - 1)) // -1 is there because that way when it returns -1 
        // It won't give the out of bounds error and will actually print friend not found
        {
            i++;

        }

        if (searcher.equals(myBFFs[i])) {

            index = i;

        } else {
            System.out.println("Friend not found");
            index = -1;

        }

    }

}
