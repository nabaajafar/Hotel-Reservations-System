/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelres;

/**
 *
 * @author Nabaa
 */
public class Customer {
    //attributes
    private int id;
    private String name;
    private String mobil_number;
    private int counterRe=0;//to knows if the customers reserved rooms or not
    
    //constractor
    public Customer(){}
    
    // methodes getter & setter & toString
    public int getID(){
        return this.id;
    }
    public void setID(int id){
        this.id=id;
    }
    
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    
    public String getMobil(){
        return this.mobil_number;
    }
    public void setMobil(String mobil){
        this.mobil_number=mobil;
    }
    
    public int getCounterRe(){
        return this.counterRe;
    }
    public void setCounterRe(int c){
        this.counterRe=c;
    }
    
    public String toString(){
     return this.getID() + " " + this.getName() + " " + this.getMobil();   
    }
}
