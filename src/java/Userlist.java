
import java.util.ArrayList;
import java.lang.NullPointerException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class Userlist {
    private String name;
    private ArrayList<String> items;

    public Userlist(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
    }
    
    public void addItems(String item)
    {
        //In Java, the java.lang.NullPointerException is thrown when a reference variable is accessed 
        //(or de-referenced) and is not pointing to any object. This error can be resolved by using a 
        //try-catch block or an if-else condition to check if a reference variable is null before dereferencing it.
       try{
           this.items.add(0, item);
       }
       catch(NullPointerException e){
            System.out.println("NullPointerException thrown!");
        }
    }
    
    public void removeItems(String itme){
        try{
           this.items.remove(itme);
       }
       catch(NullPointerException e){
            System.out.println("NullPointerException thrown!");
        }
    }
}
