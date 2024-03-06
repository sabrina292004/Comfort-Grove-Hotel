
package JavaOOP;
import java.util.ArrayList;

public class Room {
    private final int roomNumber;
    private final String type;
    private  boolean available;
    private final double price;
    public final static ArrayList<Room> allRooms = new ArrayList<>();
    static {
      
        for (int i = 1; i <= 5; i++) {
             allRooms.add(new Room (i, "Double", 150.0) );
        }

       
        for (int i = 6; i <= 15; i++) {
            allRooms.add( new Room(i, "Single", 100.0));
        }
    }

    public Room(int roomNumber, String type, double price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.available = true;
        

        
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
     public static ArrayList<Room> getAllRooms() {
        return allRooms;
    }

   
    public void ROOMINFO() {
        
        System.out.println("Room(" + roomNumber + "): Type= " + type + ", Price: " + price +"$ per night"+ '}');              
         
    }
    
    public static void viewbookings (){
        System.out.println("Booking rooms:");
        
        for(Room room: allRooms){
            
            
            if(!room.isAvailable()){
            room.ROOMINFO();
            
            
            }
           
        }
    
    }
}