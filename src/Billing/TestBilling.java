
package Billing;

import java.util.ArrayList;
import java.util.Scanner;

public class TestBilling {
     public static void main(String[] args) {
    //Admins in calss
    
    System.out.println("\t ***********************************");
    System.out.println("\t \t Welcome to Billing");
    System.out.println("\t ***********************************");
    
    
    ArrayList<Items> itemsList = new ArrayList <>();
    
    Items item1=new Items("Milk",20,6,"Alsaudia");
    Items item2=new Items("yogurt",25,2,"Alsaudia");
    Items item3=new Items("Bread",15,1,"Delta");
    Items item4=new Items("Pepsi", 23, 3.5, "Pepsico");
    Items item5=new Items("Cheetos", 30, 2.0, "Cheetos Co");
    Items item6=new Items("Butter", 26, 7.5, "Nadec");
    Items item7=new Items("Chicken", 30, 100, "AlMaraai");
    
    itemsList.add(item1);
    itemsList.add(item2);
    itemsList.add(item3);
    itemsList.add(item4);
    itemsList.add(item5);
    itemsList.add(item6);
    itemsList.add(item7);
    
    StockClerks stockclerck1= new StockClerks();
    Cashier casher1 =  new Cashier();
    
    Adminstration admin1= new Adminstration();
    admin1.set_pID("110235");
    admin1.set_pName("Quds");
    admin1.set_pPassword("Qd42u32@$");
    
    Adminstration admin2= new Adminstration();
    admin2.set_pID("110236");
    admin2.set_pName("Fatimah");
    admin2.set_pPassword("A4F#2u32@$");
    
    ArrayList <StockClerks> sArray=new ArrayList <>();
    ArrayList <Cashier> cArray=new ArrayList <>();
    
    
    String adminCheckId;
    String adminCheckP;
    String stockID;
    String stockPass;
    String cashID;
    String cashPass;
    
    int adminchoice;
    int schoice;
    int cchoice;
    int pChoice;
    
    boolean passWC=false;
    boolean passWCc=false;
    boolean addStockClercksm;
    boolean addcashier;
    boolean genarteStockClerckspassword=false;
    boolean genarteCashierpassword=false;
    
    Scanner admindata= new Scanner(System.in);
    Scanner sData= new Scanner(System.in);
    Scanner cData= new Scanner(System.in);
    
    
     do{
         
    System.out.println(" 1-Adminstration \n 2- Stock clerck \n 3-Cashier \n 0-Exit \n Enter 1 for adminstratin ,2 for Stock clerck , 3 for cashier and 0 for Exit ");
    pChoice= admindata.nextInt();
    
    // pChoice should be among {1,2,3,0}
   while ((pChoice!= 1) && (pChoice!= 2) && (pChoice!= 3) && (pChoice!= 0)){
   System.out.println("Please try again .. Incorect input!");
   System.out.println(" 1-Adminstration \n 2- Stock clerck \n 3-Cashier \n 0-Exit \n Enter 1 for adminstratin ,2 for Stock clerck , 3 for cashier and 0 for Exit ");
    pChoice= admindata.nextInt();
   }
    switch (pChoice){
        
        case 1 :
    System.out.println("plese enter your ID");
    adminCheckId=admindata.next();
    System.out.println("plese enter your password");
    adminCheckP=admindata.next();
    //exmain password if it true contineue
     while(!(( adminCheckId.equals(admin1.get_pID()) && adminCheckP.equals(admin1.get_pPassword())) || ( adminCheckId.equals(admin2.get_pID()) && adminCheckP.equals(admin2.get_pPassword())))){
      
 
    System.out.println("please try again ID or Password is not correct") ;
    System.out.println("plese enter your ID");
    adminCheckId=admindata.next();
    System.out.println("plese enter your password");
    adminCheckP=admindata.next();
    }
    
      do { 
       System.out.println(" 1- Add Stock clercks \n 2- Add cashier \n 0-Exit \n choose wich method you want to do");
    adminchoice= admindata.nextInt();
    if(adminchoice==1){
    addStockClercksm=admin1.addingstockClerk(sArray);
    if(addStockClercksm==true){ 
   System.out.println("Stock clercks added");
   }
   else 
    if(addStockClercksm==false){ 
   System.out.println("please try again , cashier  can't  added");
   }  
  
    }
    else 
    if(adminchoice==2){
   addcashier= admin1.addingcasher(cArray);
   if(addcashier==true){ 
   System.out.println("cashiers added");
   }
   else 
    if(addcashier==false){ 
   System.out.println("please try again , cashier  can't  added");
   }   
    }}
      while(adminchoice!=0);
    break;
 
        case 2:
          System.out.println("please enter your ID");
   stockID= sData.next();
   System.out.println("please enter your password");
   stockPass= sData.next();
   
   
       for(int i=0;i<sArray.size() && passWC==false;i++){
             if((stockID.equals(sArray.get(i).get_pID()) ) && (stockPass.equals(sArray.get(i).get_pPassword())) )
       {  passWC=true;
       do{
           System.out.println(" 1-Add item \n 2-Delete item \n 3-Update item \n 4-Add offer \n 0-Exit  \n Choose wich method you want" );
       
   schoice= sData.nextInt();
   
   switch(schoice){
       case 1 : { 
           if (stockclerck1.addItems(itemsList)==true)
               System.out.println("\n The items are added .. \n");
                Items.view(itemsList);
           
       break;}
       case 2 : {if (stockclerck1.deleteItems(itemsList)==true)
               System.out.println("\n The item is deleted .. \n");
                      Items.view(itemsList);
       break;}
       case 3 : {if(stockclerck1.updateItems(itemsList)==true)
                System.out.println("\n The item is updated .. \n");
                    Items.view(itemsList);
       break;}
       case 4:  {if (stockclerck1.addOffer(itemsList)==true)
                System.out.println("\n The Offer is added .. \n");
                     Items.view(itemsList);
       break;}
           
   }}
       while(schoice!=0);
               } else {
    
     System.out.println("please try again your ID or Password is not correct"); 
                System.out.println("please enter your ID");
                stockID= sData.next();
                System.out.println("please enter your password");
                stockPass= sData.next();}}
   break;
        case 3: 
           System.out.println("please enter your ID");
   cashID= cData.next();
   System.out.println("please enter your password");
   cashPass= cData.next();
   
   
       for(int i=0;i<cArray.size() && passWCc==false;i++){
             if((cashID.equals(cArray.get(i).get_pID()) ) && (cashPass.equals(cArray.get(i).get_pPassword())) )
       {  passWCc=true;
       do{
           System.out.println(" 1-creat bill \n 2-Delete bill \n 3-Modify bill \n 4-Print bill \n 0-Exit \n Choose wich method you want" );
       
   cchoice= cData.nextInt();
   
   switch(cchoice){
       case 1 : {if (casher1.CreateBill(itemsList)==true)
             System.out.println("\n The Bill is created .. \n");
       break;}
       case 2 : {if(casher1.DeleteBill()==true)
             System.out.println("\n The Bill is deleted .. \n");
       break;}
       case 3 : {if(casher1.ModifyBill(itemsList)==true)
             System.out.println("\n The Bill is modified .. \n");
       break;}
       case 4:  {casher1.PrintBill();
       break;}
           
   }}
       while(cchoice!=0);
       } else {
    
     System.out.println("please try again your ID or Password is not correct"); 
                System.out.println("please enter your ID");
                cashID= cData.next();
                System.out.println("please enter your password");
                cashPass= cData.next();}}
        
   break;
    }}
     while(pChoice!=0);
    


    }

}
