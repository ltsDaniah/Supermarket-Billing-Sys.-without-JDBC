
package Billing;


import java.util.Scanner;

public abstract class  Payment{
    protected String type;
    Bill b = new Bill();
    public Payment() {

    }

    public Payment(String type) {

    }
    public void chooseType (){
        Scanner input=new Scanner(System.in);

        System.out.println("Enter Payment Type:\n1-CreditCard\n2-Cash");
        int option=input.nextInt();
        if(option==1)
            type="Credit Card";
        else if(option==2)
            type="Cash";
    }
    //it was void
    public abstract double offer(double totalC);
      
}



class CreditCard extends Payment {
    private boolean payment;
    CreditCard(){}
    public  boolean   getPayment(){
        return this.payment;
    }
    void setPayment(boolean payment){
        this.payment=payment;
    }

    public  boolean paymentIsDone(){
        return this.payment;
    }
    @Override
    public double offer(double totalC){
        
        if(totalC>100&&totalC<500){
            totalC-=totalC*0.05;
        }
        else if(totalC>500){
            totalC-=totalC*0.10;
        }
        return totalC;
    }

}
class Cash extends Payment {
    private double payedAmount;
    Cash(){}

    public void setPayAmount(double payedAmount ){
        this.payedAmount=payedAmount;
    }

    public double getPayAmount(){
        return this.payedAmount;
    }

    public double returnedAmount(double total,double payedAmount ) {
        
        double remained = payedAmount-total;
       
        return remained;
    }
    
    public double offer(double totalAfter ){
       
        if(totalAfter>200&&totalAfter<500){
            totalAfter-=totalAfter*0.05;
        }
        else if(totalAfter>500){
            totalAfter-=totalAfter*0.10;
        }
        else if(totalAfter<200)
        {return totalAfter;}
        return totalAfter;
    }
}
