/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfphonebookarray;

/**
 *
 * @author dailenperez
 */
public class BFF {

    /** instance variables for a best friend object initialized.**/
    private String firstName;
    private String lastName;
    private String nickName;
    private String cellPhone;
    private String email;
/** @param firstName passes the first name of a friend when its being created **/
/** @param lastName passes the last name of a friend when its being created **/
/** @param nickName passes the nick name of a friend when its being created **/
/** @param cellPhone  passes the cell phone of a friend when its being created **/
/** @param email passes the email of a friend when its being created
 
 Constructor for BFF object **/
    public BFF(String firstName, String lastName, String nickName, String cellPhone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.cellPhone = cellPhone;
        this.email = email;
    }
    

/** @param firstName passes the first name of a friend when its being created **/
/** @param lastName passes the last name of a friend when its being created **/
/** @param nickName passes the nick name of a friend when its being created 
 
 Overloaded constructor for BFf objects that will make it easier to search through them**/
    
    public BFF(String firstName, String lastName, String nickName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
    }

    // Getters and setters for BFF objects
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Over riden toString to inlude all instance variables of the BFF class.
    @Override
    public String toString() {
        return "\nBestFriend:" + " firstName:" + firstName + ", lastName:" + lastName + ", nickName:" + nickName + ", cellPhone:" + cellPhone + ", email:" + email;
    }
    
    @Override // overideng equals method at object level to make it specific for checking if an object is of type BFF 
    /** 
     @param obj any object can be passed.
     * Method returns true if object passed is an instance of BFF and has same first
     * name , last name , nickname . It returns false if  the object doesn't have both the same.
     **/
    
    public boolean equals(Object obj)
    {
        BFF other;
        if(obj==null)
            return false;
        if(obj instanceof BFF)  
        {
            other = (BFF)obj;
        }
        else
            return false;
        
        if(firstName.equals(other.firstName) &&
                lastName.equals(other.lastName) &&
                nickName.equals(other.nickName)){
         
            return true;
        }else{
          
            return false;
        }
    }
     
}
