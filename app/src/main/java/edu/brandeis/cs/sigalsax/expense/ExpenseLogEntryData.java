package edu.brandeis.cs.sigalsax.expense;

/**
 * Created by SigalSax on 11/8/17.
 */

import java.util.Date;
public class ExpenseLogEntryData {

    private String description;
    private String id;
    private int price;
    private String dateString;

    public ExpenseLogEntryData(String id, String description){
//        int price
        this.id=id;
        this.description=description;
//        this.price= price;
        Date date= new Date();
        this.dateString= date.toString();
    }



    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public void setId(String id){
        this.id=id;

    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price){
        this.price=price;
    }
    public String getDate(){
        return dateString.toString();
    }
    public void setDate(Date d){
        this.dateString=d.toString();
    }
    public String toString(){
        return "" + id + description + "\n"+ dateString;
        // + price;
    }
}

