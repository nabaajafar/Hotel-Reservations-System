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
import java.util.ArrayList;
public class Reservation {
     //attributes
    private int night;
    private Customer customer=new Customer();
    private ArrayList<Rooms>rooms=new ArrayList<>();
    
    //constractors
    public Reservation(){};
    public Reservation(int night,ArrayList<Rooms>rooms,Customer customer){
        this.night=night;
        this.rooms=rooms;
        this.customer=customer;
    }
    
    // methodes getter & setter
    public int getNight(){
        return this.night;
    }
    public void setNight(int night){
        this.night=night;
    }
    
    public Customer getCustomer(){
        return this.customer;
    }
    public void setCustomer(Customer customer){
        this.customer=customer;
    }
    
    public ArrayList<Rooms> getRooms(){
        return this.rooms;
    }
    public void setRooms(Rooms room){
        rooms.add(room);
    }
}
