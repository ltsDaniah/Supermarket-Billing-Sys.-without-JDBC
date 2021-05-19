
package Billing;

import java.util.ArrayList;
import java.util.Scanner;
enum Fields {uItemQuantity,uItemPrice,uItemSupplier};
    class StockClerks extends Person {

        public StockClerks() {
        }
        boolean addItems(ArrayList <Items> itemsList){
            int numberOfItems;
            int quantityOfItems;
            String nameOfItem;
            double priceOfItems;
            String supplierOfItem;
            int arrayListSize;

            Scanner dataItems= new Scanner(System.in);

            System.out.print("How many items you want to add: ");
            numberOfItems= dataItems.nextInt();
            for(int i=0;i<numberOfItems;i++){
                System.out.print("\nType item's name: ");
                nameOfItem=dataItems.next();
                System.out.print("\nType item's quantity: ");
                quantityOfItems=dataItems.nextInt();
                System.out.print("\nType item's price: ");
                priceOfItems=dataItems.nextDouble();
                System.out.print("\nType item's supplier: ");
                supplierOfItem=dataItems.next();
                Items newItem = new Items(nameOfItem,quantityOfItems,priceOfItems,supplierOfItem);
                itemsList.add(newItem);

            }

            return true;
        }
        boolean deleteItems(ArrayList <Items> itemsList){
            Scanner deleteItems= new Scanner(System.in);
            String nameOfDeleteItem;
            System.out.print("Type the name of item  you want to delete: ");
            nameOfDeleteItem=deleteItems.next();
            for(int i=0;i<itemsList.size();i++){
                if(itemsList.get(i).itemName.equals(nameOfDeleteItem))
                {
                    itemsList.remove(i);
                }
            }
            return true;
        }
        boolean updateItems(ArrayList <Items> itemsList){
            String uItemName;
            int arrayListSize;
            String fieldName;
            double newPrice;
            int newQuantity;
            String newSupplier;

            Scanner dataItems= new Scanner(System.in);

            System.out.println("Enter the item name you want to update: ");
            uItemName = dataItems.next();
            for (int i = 0; i< itemsList.size(); i++){
                if (itemsList.get(i).itemName.equals(uItemName)){
                    System.out.println("Enter the field name that you want to update:\n uItemQuantity = Quantity \n uItemPrice = Price \n uItemSupplier = Supplier \n");
                    fieldName = dataItems.next();
                    Fields fields = Fields.valueOf(fieldName);
                    switch (fields){
                        case uItemPrice:
                            System.out.println("Enter the new price: ");
                            newPrice = dataItems.nextDouble();
                            itemsList.get(i).itemPrice = newPrice;
                            break;
                        case uItemQuantity:
                            System.out.println("Enter the new quantity: ");
                            newQuantity = dataItems.nextInt();
                            itemsList.get(i).itemQuantity = newQuantity;
                            break;
                        case uItemSupplier:
                            System.out.println("Enter the new supplier: ");
                            newSupplier =dataItems.next();
                            itemsList.get(i).supplier = newSupplier;
                            break;
                    }
                }
            }
            return true;
        }
        boolean addOffer(ArrayList <Items> itemsList){
            String oItemName;
            double dAmount;
            double oNewAmount;
            Scanner dataItems= new Scanner(System.in);

            System.out.println(" Enter the item name that you want to add offer in: ");
            oItemName = dataItems.next();
            for (int i = 0; i< itemsList.size(); i++){
                if (itemsList.get(i).itemName.equals(oItemName)){
                    System.out.println("Enter the discount amount {if 10% write it like 0.10}: ");
                    dAmount = dataItems.nextDouble();
                    oNewAmount = itemsList.get(i).itemPrice - (itemsList.get(i).itemPrice * dAmount);
                    itemsList.get(i).itemPrice = oNewAmount;
                }
            }
            return true;
        }

    }


