
package Billing;

import java.util.ArrayList;
import java.util.Scanner;
enum billFields {bItemQuantity,bItemName};
enum paymentType {cash, creditCard};
public class Cashier extends Person {
    ArrayList<Items> billList = new ArrayList <>();
    public Cashier(){}

    Scanner billItems = new Scanner(System.in);

    public boolean CreateBill(ArrayList <Items> itemsList){
        billList.removeAll(billList);
        String cItemName;
        int quantityOfItems = 0;
        double totalPrice = 0.0;
        int number;
        System.out.println("Enter number of items: ");
        number = billItems.nextInt();
        
        for(int i = 0; i < number; i++) 
        {
            System.out.println("Enter the item's name: ");
            cItemName = billItems.next();
            
            for (int j = 0; j< itemsList.size(); j++) {
                if (itemsList.get(j).itemName.equals(cItemName)) {
                    System.out.println("Enter the item quantity: ");
                    quantityOfItems = billItems.nextInt();
                    totalPrice = itemsList.get(j).itemPrice * quantityOfItems;
                  }
            }
            
           
            Items newBill = new Items(cItemName, quantityOfItems, totalPrice, "");
            billList.add(newBill);
        }
        
        Bill nBill = new Bill();
        System.out.println(nBill.getDateAndTime());
        return true;
    }

    public boolean DeleteBill() {

        String deleteItem;
        System.out.print("Type the name of item that you want to delete: ");
        deleteItem = billItems.next();
        for (int i = 0; i < billList.size(); i++) {
            if (billList.get(i).itemName.equals(deleteItem))
            {
                billList.remove(i);
            }
        }
        return true;
    }
    public boolean ModifyBill(ArrayList <Items> itemsList){
        String fieldName;
        String newName;
        int newQuantity;
        double totalPrice = 0.0;
        String wrongItem;
        System.out.println("Enter the wrong item name that you want to modify: ");
        wrongItem = billItems.next();
        System.out.println("Enter the field name that you want to update: Type \"bItemName\" to modify the name OR \"bItemQuantity\" to modify the Quantity  ");
        fieldName = billItems.next();
        billFields bFields = billFields.valueOf(fieldName);
        for (int i = 0; i< billList.size(); i++){
            if(billList.get(i).itemName.equals(wrongItem)){
                switch (bFields) {
                    case bItemName:
                         System.out.println("Enter the new Name: ");
                         newName = billItems.next();
                         billList.get(i).itemName = newName;
                         break;
                    case bItemQuantity:
                         System.out.println("Enter the new quantity: ");
                         newQuantity = billItems.nextInt();
                         billList.get(i).itemQuantity = newQuantity;
                         totalPrice = itemsList.get(i).itemPrice * newQuantity;
                         billList.get(i).itemPrice = totalPrice;
                         break;
                }
            }
        }
        return true;
    }
    public void PrintBill() {
        
        System.out.println("Bill \n ");
       
        for (int i = 0; i < billList.size(); i++) {
            System.out.println(billList.get(i).itemName + "  " + billList.get(i).itemQuantity + "  " + billList.get(i).itemPrice);
        }
        Cash ca = new Cash();
        CreditCard cc = new CreditCard();
        String pType;
        double cashAmount;
        System.out.print("Enter the payment type: ");
        pType = billItems.next();
        paymentType type = paymentType.valueOf(pType);
        switch (type) {
            case cash:
                System.out.print("Enter the gavin amount: ");
                cashAmount = billItems.nextDouble();
                ca.setPayAmount(cashAmount);
                System.out.println("************");
                System.out.println("Total:    " +(ca.offer(FindTotal())));
                System.out.println("Payed Amount:    " +cashAmount);
                System.out.println("Returnd Amount:    " +( ca.returnedAmount(FindTotal(),cashAmount)));
                break;
            case creditCard:
                System.out.println("************");
                System.out.println("Total:    " + cc.offer(FindTotal()));
                break;
        }
    }
    public double FindTotal(){
        double total = 0.0;
        for(int i = 0; i< billList.size(); i++){
            total+= billList.get(i).itemPrice;
        }
        return total;
    }
}
