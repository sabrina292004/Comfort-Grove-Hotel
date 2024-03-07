
package JavaOOP;
import java.util.ArrayList;
// maram's start
public class Room {
    private final int roomNumber;
    private final String type;
    private  boolean available;
    public final double price;
    public final static ArrayList<Room> allRooms = new ArrayList<>();
    static {
      
        for (int i = 101; i <= 105; i++) {
             allRooms.add(new Room (i, "Double", 150.0) );
        }

       
        for (int i = 106; i <= 115; i++) {
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
        
        System.out.println("{ Room(" + roomNumber + "): , Type : " + type + " , price : "+price + " }");              
         
    }
    // maram's end
    // rana's start
    public static void viewbookings (){
        System.out.println("Booking rooms:");
        
        for(Room room: allRooms){
            
            
            if(!room.isAvailable()){
            room.ROOMINFO();
            
            
            }
            //rana's end
           
        }
    
    }
}
