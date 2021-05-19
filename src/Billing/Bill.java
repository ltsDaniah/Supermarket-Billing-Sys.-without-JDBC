
package Billing;

import java.time.LocalDateTime;


public class Bill {
    private LocalDateTime dateAndTime;
    private int billNumber;
    private static int billNumberToday;
    private double total;

    Bill(){
        billNumberToday++;
    }

    public LocalDateTime  getDateAndTime (){
        dateAndTime = LocalDateTime.now();
        return dateAndTime;
    }
    public void setBillNumber (int BillNumber){
        billNumber=BillNumber++;
    }
    public int getBillNumber (){
        return billNumber;}


    public void setTotal(double total) {
        this.total=total;
    }

    public double getTotal(){
        return total;
    }

    public double calculateTotal()
    {
        Cashier c= new Cashier();
        return c.FindTotal();
    }
}
