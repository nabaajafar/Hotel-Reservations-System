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
public class Rooms {
     //attributes
   private int num;
   private double price;
   private boolean booked=false;
   
   //constractors
   public Rooms(){}
   public Rooms(int num,double price){
       this.num=num;
       this.price=price;
   }
   
   // methodes getter & setter
   public int getNum(){
       return this.num;
   }
   public void setNum(int num){
       this.num=num;
   }
   
   public double getPrice(){
       return this.price;
   }
   public void setPrice(double price){
       this.price=price;
   }
   
   public void cancel(){///.......................to make the room available 
        booked=false;
    }
    public boolean isBooked(){//......... to check wither the room reseved or not
       return booked; 
    }
    public void setBooked(){//...............reserve the room
        this.booked=true;
    }
    
    public String toString(){
        return" Room's Number: "+this.getNum()+" Room's Price: "+this.getPrice();
    }
}
