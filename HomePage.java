// sabrina's start 
package JavaOOP;
import java.util.Scanner;
public class HomePage {
    public static void main(String[] args) {
        displayHomePage();

    }
     public static void displayHomePage() {
        int choice;
        Client client1 = new Client();
        System.out.println("WELCOME TO OUR MOTEL COMFORT GROVE IN IBIZA !!!");
        do{
        
        System.out.println("1.Explore available rooms");
        System.out.println("2.Book a room");
        System.out.println("3.Display booked rooms");
        System.out.println("4.Exit the system");
        System.out.println("Please choose an option:");

        choice = new Scanner(System.in).nextInt();

        switch (choice) {
            case 1:
                exploreRooms();
                break;
            case 2:
                client1.bookRoom();
                break;
            case 3:
                Room.viewbookings();
                break;
            case 4:
                exitSystem();
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
                displayHomePage();
                break;
        }
        }while(choice !=4);
    }
    // malak's start
    public static void exploreRooms() {
        System.out.println("Available rooms:");
        for(Room room: Room.getAllRooms()){
            
            if(room.isAvailable()){
            room.ROOMINFO();         
            }
           
        }

    }
    // malak's end
    public static void exitSystem() {
        System.out.println("Thank you for using the Hotel Management System. Goodbye!");
        System.exit(0);
    }
}
// sabrina's end
