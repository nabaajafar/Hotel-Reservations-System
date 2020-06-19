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
import java.util.Scanner;
public class HotelRes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//int exit=0;// to tell me when i have to stop
        //while(exit==0){
       
      ArrayList<Reservation> reservation=new ArrayList<>(); 
      ArrayList<Rooms> hotal=new ArrayList<>();
      Rooms room=new Rooms();
      Scanner input=new Scanner(System.in);
      Scanner inputSt=new Scanner(System.in);///for nextLine
      
      int choice=10;
      do{
          try{
      System.out.println("HOTEL MANAGEMENT APPLICATION!\n"); 
      System.out.println("&&&&&&&&&&&& Main List &&&&&&&&&&&&\n");
      System.out.println("[1]Administrator\n[2]Customer\n[0]Exit\nyour choice: ");           
       choice=input.nextInt();
      
     
        switch(choice){
            case 1:
                System.out.println("\n[1]Add Room\n[2]View all Rooms in hotal\n[3]updat Rooms\n[4]delete Room\n[0]Return to the main menu\nyour choice: ");
                int b=input.nextInt();
                while(b!=0){
                    switch(b){
                        case 1:              
                          addRoom(hotal);
                          break;
                   
                        case 2:
                          viewRooms(hotal);
                          break;  
                   
                        case 3:
                            if(hotal.isEmpty()){//...............cheak if there is a room or not
                            System.out.println("NO ROOMS");
                               }
                            else{
                            System.out.println(" The rooms that are already exisiting\n\n");
                            viewRooms(hotal);
                            System.out.println("\nEnter the room number which you want to update it:\n");
                            int roomNumber=input.nextInt();
                            updatingRoom(hotal, findRoom(hotal, roomNumber));
                            }//ends else
                          break;
                        case 4:
                          deleteRooms(hotal);
                          break;
                        default:
                          System.out.println("INVALID INPUT!!");
                    }//ends switch case 1
                    System.out.println("\n[1]Add Room\n[2]View all Rooms in hotal\n[3]updat Rooms\n[4]delete Room\n[0]Return to the main menu\nyour choice: ");
                    b=input.nextInt();
                }//ends while case 1
            break;//for case 1
            
            case 2:
                
                Customer cu=new Customer();
                Reservation rese=new Reservation();
                int cheak;//value to cheak if this customer has been add befor or not
                System.out.println("Welcom our customer\n");
                System.out.println("Please Enter your ID: ");
                cu.setID(input.nextInt());
                cheak=foundCust(reservation, cu.getID());// calling the method
                if(cheak==-1){// if not founds the id 
                    System.out.println("Please enter customer name: ");
                    cu.setName(inputSt.nextLine());
                    System.out.println("Please enter customer mobil: ");
                    cu.setMobil(inputSt.nextLine());
                    rese.setCustomer(cu);
                    reservation.add(rese);
                    cheak=reservation.size()-1;//to add a new customer
                }//ends if(not founds the id)
                
                else{// found the id
                    cu=reservation.get(cheak).getCustomer();
                }// ends else
                
                
                System.out.println("[1]Booking a room\n[2]View your reserved rooms\n[3]update number of night\n[4]Check out\n[0]Return to the main menu\nyour choice:");
                int f=input.nextInt();
                while(f!=0){
                    switch(f){
                        case 1:
                            System.out.println("===============\nBOOKING\n===============");
                            if(hotal.isEmpty()){
                                System.out.println("\nSORRY THE ADMINSTRATOR DID NOT ADD ANY ROOMS\n");
                            }
                            else{
                                viewRooms(hotal);
                                try{
                                     
                                System.out.println("Please enter number of night: ");
                                reservation.get(cheak).setNight(input.nextInt());
                                
                                System.out.println("How many rooms do you wants to reserved: ");
                                int roomNum = input.nextInt();
                                for(int j=0;j<roomNum;j++){
                                    System.out.println("Please enter room number: ");
                                    int numRoom=input.nextInt();
                                    //find room, then add to reservation.get(cheak)
                                        numRoom = findRoom(hotal, numRoom);//calling the method
                                        if(numRoom!=-1){//found
                                            room=hotal.get(numRoom);
                                            if(room.isBooked()){
                                                System.out.println("Sorry this room is already has been booked");
                                            }// end inner if
                                            else{
                                                room.setBooked();
                                                reservation.get(cheak).setRooms(room);
                                                System.out.println("Thank you for booking "+room.toString());
                                                cu.setCounterRe(1);
                                            }//ends else
                                        }// ends outer if
                                }//ends for loop
                                 }//ends try block 
                                catch(Exception e){
                                  System.out.println("\nSorry..you have to enter numeric value!!");
                                   }//ends catch
                            }//ends outer else
                            break;
                            
                        case 2:
                            System.out.println("===============\nDISPLAYING\n===============");
                            double total=0;
                            int numN;
                            if(cu.getCounterRe()==0){
                                System.out.println("No RESERVATION\n");
                            }
                            else if(cu.getCounterRe()==1){
                                numN=reservation.get(cheak).getNight();
                                for(int i=0;i<reservation.get(cheak).getRooms().size();i++){
                                    Rooms ro=reservation.get(cheak).getRooms().get(i);
                                    System.out.printf("%-20s %-15s %s \n","Room's Number", "Room's price","Number of Night");
                                    System.out.printf("%-20s %-15s  %s\n", ro.getNum(),ro.getPrice(),reservation.get(cheak).getNight());
                                  
                                    total=total+(ro.getPrice()*numN);//
                                }//ends for loop
                                   System.out.println(" \nYour total is "+total+"\n");
                            }//ends else
                            break;
                            
                        case 3:
                            System.out.println("\n=============== update number of night ===============\n");
                            if(cu.getCounterRe()==0){
                                System.out.println("NO RESERVATION\n");
                            }
                            else{
                            System.out.println("You reserved for " + reservation.get(cheak).getNight() + " nights\n");
                            System.out.println("Please enter the new value for night\n");
                            reservation.get(cheak).setNight(input.nextInt());
                            }//ends else
                            break;
                            
                        case 4:
                             System.out.println("\n=============== \nCheck Out\n ===============\n");
                            if(cu.getCounterRe()==0){
                                System.out.println("You did not reserved any room! as result you have to booked a rooms to be able to check out\n");
                            }
                            else{
                                
                        for(int j=0;j<reservation.get(cheak).getRooms().size();j++){
                        int roomIndex = findRoom(hotal, reservation.get(cheak).getRooms().get(j).getNum());
                       
                        if (roomIndex!=-1){
                            hotal.get(roomIndex).cancel();
                        }
                         }
                         reservation.remove(cheak);
                
                        System.out.println(" \nYou have been Checked Out!! ");
                     
                        cu.setCounterRe(0);
                            }//ends else1
                          break;
                       
                        default:
                              System.out.println("INVALID INPUT!!");
                            
                    }//ends switch case 2
                    
                    System.out.println("[1]Booking a room\n[2]View your reserved rooms\n[3]update number of night\n[4]Check out\n[0]Return to the main menu\nyour choice:");
                    f=input.nextInt();
                }//ends while case 2
            break;
            
            default:
                System.out.println("INVALID INPUT!!");
                
        }//ends outer switch
          
      
          }
          catch(Exception e){
              input.next();
              System.out.println("\nSorry..you have to enter numeric value!!");
       }//ends catch
      }while(choice!=0);//ends outer do while
      System.out.println("\tTHANK YOU\n\tGOODBYE");
       
    }//......................................................................ends main method
     //all these methods are static because they are in main class
    //-------------------------------------------------------------------------------------------------
   // this method to add a new room 
    public static void addRoom(ArrayList<Rooms> hotal){
        Rooms room=new Rooms();
        Scanner input=new Scanner(System.in);
        System.out.println("===============\nADDING ROOMS\n===============");
        System.out.println("Please enter room's number: ");
        try{
        room.setNum(input.nextInt());
        System.out.println("Please enter room's price: ");
        room.setPrice(input.nextDouble());
        hotal.add(room);
        }//ends try block
        catch(Exception e){
           System.out.println("Sorry..you have to enter numeric value!!"); 
        }// ends catch
    }
    //-------------------------------------------------------------------------------------------------
     //....................this method will display all rooms in hotal  and show if it available or not
    public static void viewRooms(ArrayList<Rooms> hotal){
   
    if(hotal.isEmpty()){//...............cheak if there is a room or not
           System.out.println("NO ROOMS");
       }
    else{
        for(int i=0;i<hotal.size();i++){
          System.out.printf("%-20s %-15s %-15s \n","Room's Number", "Room's price", "booked");
          System.out.printf("%-20s %-15s %-15s \n", hotal.get(i).getNum(),hotal.get(i).getPrice(),hotal.get(i).isBooked());
        }
    }
    
    }//end methode
    //-------------------------------------------------------------------------------------------------
    //this method help us to cheak if this room is already adding not

    public static int findRoom(ArrayList<Rooms> hotal, int roomNum){
        for(int i=0;i<hotal.size();i++){//go one by one on each index to cheak
            Rooms s=hotal.get(i);
            if(s.getNum()==roomNum){
                return i;//founds
            }
        }
     System.out.println("Sorry we can not found this room");
     return -1;//not founds outs indexes
    }//.......end method
    //-------------------------------------------------------------------------------------------------
    
    // This method help us to cheak if this id is already adding befor or not
    public static int foundCust(ArrayList<Reservation> reservation, int customerID){
        
    for(int i=0;i<reservation.size();i++){// go one by one on each index to cheak
        if(reservation.get(i).getCustomer().getID()==customerID){
            System.out.println("\n"+String.valueOf(reservation.get(i).getCustomer().getID()+" "+String.valueOf(i)));
            return i;//founds
        }
    }
    return -1;// not founds outs indexes
    }
    //--------------------------------------------------------------------------------------------------
   
 //.....................to update room information
    public static void updatingRoom(ArrayList<Rooms> hotal, int j)
    {
    
            Scanner input = new Scanner(System.in);
           
            System.out.println("\n========== Updating ==========\n ");
            System.out.printf("%-20s %-15s \n","Room's Number", "Room's price");
            System.out.printf("%-20s %-15s \n", hotal.get(j).getNum(),hotal.get(j).getPrice());
            System.out.println("what do you want to update:\n[1]Room nmber\n[2]Room price\n[3]Exit\nyour choice: ");
            int choice=input.nextInt();
            while(choice!=3){
            switch(choice){
            
                case 1:
                    System.out.println("Enter the new room number:");
                    hotal.get(j).setNum(input.nextInt());
                    System.out.println("**Room number is updated**");
                    System.out.println("\nRoom Updated with the updated information: ");
                    System.out.printf("%-20s %-15s \n","Room's Number", "Room's price");
                    System.out.printf("%-20s %-15s \n", hotal.get(j).getNum(),hotal.get(j).getPrice());
                    
                    
                    break;
                    
                case 2:
                    System.out.println("Enter the new room price:");
                    hotal.get(j).setPrice(input.nextInt());
                    System.out.println("**Room price is updated**");
                    System.out.println("\nRoom Updated with the updated information: ");
                    System.out.printf("%-20s %-15s \n","Room's Number", "Room's price");
                    System.out.printf("%-20s %-15s \n", hotal.get(j).getNum(),hotal.get(j).getPrice());
                    
                    break;
                    
                    
                default:
                    System.out.println("\nINVALID INPUT \n");
                    
                    
            }//end switch
            System.out.println("what do you want to update also:\n[1]Room nmber\n[2]Room price\n[3]Exit\nyour choice: ");
            choice=input.nextInt();
            
            }//end while
            System.out.println("\n **Done** \n");
        
    }//end updating room 
    //-------------------------------------------------------------------------------------------------
    //.....................................this method helps to delete rooms
    public static void deleteRooms(ArrayList<Rooms> hotal){
        Scanner input=new Scanner(System.in);
        int flag=0;
        System.out.println("===============\nDELETING ROOMS\n===============");
        if(hotal.isEmpty()){
            System.out.println("NO ROOMS");
        }
        else{
            try{
            System.out.println("please enter room's number: ");
            int num=input.nextInt();
           
            
            for(int i=0;i<hotal.size();i++){
                if(hotal.get(i).getNum()==num){
                    hotal.remove(i);
                    flag=1;
                    System.out.println("DONE\n");
                }//ends if
            }//ends for loop
             }//ends try
            catch(Exception e){
                System.out.println("Sorry..you have to enter numeric value!!");
            }//ends catch
            if(flag==0){
                System.out.println("Sorry can not founds");
            }
        }//ends else
    
    }
    //-------------------------------------------------------------------------------------------------
}
