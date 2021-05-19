
package Billing;


import java.util.Iterator;
import java.util.ArrayList;

public class Items {
    
    String itemName;
    int itemQuantity;
    double itemPrice;
    String supplier;
    
    
    
    public Items()
    {
        
    }
    
    public Items(String itemName,int itemQuantity,double itemPrice,String supplier)
    {
        this.itemName= itemName;
        this.itemQuantity= itemQuantity;
        this.itemPrice= itemPrice;
        this.supplier= supplier;
        
    }
      
        
    //static void View ()
    //{
        //Iterator itr = itemsA.iterator();
        //while (itr.hasNext())
        //{
          //  Items items = (Items)itr.next();
            //System.out.println("Name: " + items.itemName + "Quantity: " + items.itemQuantity + "Price: " + items.itemPrice + "Supplier: " + items.supplier);
         //   System.out.println("View method");
        //}
    
    public static void view(ArrayList<Items> tobedisp)
    {
        /*for (int i=0; i<tobedisp.size(); i++ )
        {
            System.out.println(tobedisp.get(i));
        }*/
        Iterator itr = tobedisp.iterator(); //to iterate through ArrayList
        while (itr.hasNext())
        {
            Items items=(Items)itr.next();
            System.out.println("Name: "+ items.itemName + "\nQuantity: " + items.itemQuantity + "\nPrice: " + items.itemPrice );
            System.out.println("Supplier: " + items.supplier +"\n");
        }
    }
}

