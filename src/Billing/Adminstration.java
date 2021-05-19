
package Billing;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

//Adminstration sub class
public class Adminstration extends Person {
//defult constructor 
    public Adminstration() {
    }
//adding stockClerks
    boolean addingstockClerk(ArrayList <StockClerks> sArray){
       int addChoice;
        String EID;
        String EName;
        boolean generatingP;
        do{
        StockClerks stockclerck=new StockClerks();
        Scanner data= new Scanner(System.in);
        System.out.println("Enter StockClerk ID ");
        EID=data.next();
        stockclerck.set_pID(EID);
        System.out.println("Enter StockClerk name ");
        EName=data.next();
        stockclerck.set_pName(EName);
        generatingP=genearaingtePassword(stockclerck);
        sArray.add(stockclerck);
        
        System.out.println("Type 0 if you finish adding or 1 if you want to add another one");
        addChoice= data.nextInt();
         }while(addChoice!=0);
        return true;   
    }
 //adding casher 
    boolean addingcasher(ArrayList <Cashier> cArray){
        int addChoice;
        String EID;
        String EName;
        boolean generatingP;
        
        do{
        Cashier cashier=new Cashier();
        Scanner data= new Scanner(System.in);
        System.out.println("Enter Cashier ID ");
        EID=data.next();
        cashier.set_pID(EID);
        System.out.println("Enter Cashier name ");
        EName=data.next();
        cashier.set_pName(EName);
        generatingP=genearateingPassword(cashier);
        cArray.add(cashier);
        System.out.println("Type 0 if you finish adding or 1 if you want to add another one");
        addChoice= data.nextInt();
         }while(addChoice!=0);
        return true;    
    }
    //creating passord of stockClerks
    boolean genearaingtePassword(StockClerks employee){
//    list of charecters nedded in password
    String charlist="@#$%";
//  rendom number take a random index of charlist
    Random randomIndex= new Random();
    String passwordstring= employee.get_pName().trim().toLowerCase().charAt(0)+""+employee.get_pName().trim().toLowerCase().charAt(1)+employee.get_pName().trim().toUpperCase().charAt((employee.get_pName().length())/2)+""+charlist.charAt(randomIndex.nextInt(charlist.length()))+""+employee.get_pID().substring(1, 4)+"$";
    employee.set_pPassword(passwordstring);
      System.out.println("The password :"+ employee.get_pPassword() +" is Valid & Generated sucssesfully");  
        return true;
    }
    //creating passord of stockClerks
    boolean genearateingPassword(Cashier employee){
       String charlist="@#$%";
    Random randomIndex= new Random();
    String passwordstring= employee.get_pName().trim().toLowerCase().charAt(0)+""+employee.get_pName().trim().toLowerCase().charAt(1)+employee.get_pName().trim().toUpperCase().charAt((employee.get_pName().length())/2)+""+charlist.charAt(randomIndex.nextInt(charlist.length()))+""+employee.get_pID().substring(1, 4)+"$";
    employee.set_pPassword(passwordstring);
      System.out.println("The password :"+ employee.get_pPassword() +" is Valid & Generated sucssesfully");  
        return true;
        
    }
}
