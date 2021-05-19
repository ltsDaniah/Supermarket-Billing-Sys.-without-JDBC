
package Billing;

import java.util.regex.Pattern;
import java.util.regex.Matcher;



public class Person {
    
    private String pID;
    private String pName;
    private String pPassword;
    
    Person(){
    }

    // parametrized constructer
    Person ( String pID, String pName){
        this.pID = pID;
        this.pName = pName;
    }
    
    
    // Setter and Getter for pID
    public void set_pID ( String pID ){
        this.pID=pID;
    }
    public String get_pID (){
        return pID;
    }
    
    
    // Setter and Getter for pName
    public void set_pName ( String pName ){
        this.pName=pName;
    }
    public String get_pName (){
        return pName;
    }
    
    
    // Setter and Getter for pPassword
    public void set_pPassword ( String pPassword ){
        this.pPassword=pPassword;
       passwordValid();
    }
    public String get_pPassword (){
        return pPassword;
    }
    
    
    
    // method to check the validity of pPassword

    public void passwordValid(){
        
        
        /*
                  ^          # start of the string
               (?=.*\\d)     # a digit must occur at least once
               (?=.*[a-z])   # a lower case letter must occur at least once
               (?=.*[A-Z])   # an upper case letter must occur at least once
               (?=.*[@#$%])  # a single character in the list @#$% 
                   $         # end of the string
        */
        
        
        
        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
        
        
        // to check the space condition
        if (pPassword.contains(" ")){
            System.out.println("password should not contain space..");
          }
        
        else {
        
       //pattern has static method called compile
        Pattern pattern = Pattern.compile(regex);
        
        //check if pPassword matches the pattern?
        Matcher matcher = pattern.matcher(pPassword);
        
        boolean result = matcher.matches();
        
        if ( result == false )
        
         System.out.println("The password : "+pPassword+" is not Valid"); }

        }
   
    }

