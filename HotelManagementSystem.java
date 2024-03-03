package JavaOOP;
import java.util.Scanner;
import java.util.ArrayList;
// HotelManagementSystem.java
public class HotelManagementSystem{
    // A scanner for user input
    private final Scanner scanner = new Scanner(System.in);
    // A list of rooms in the hotel
    public ArrayList<Room> rooms ;
    // A list of bookings made by customers
    public ArrayList<Booking> bookings ;
    // A constructor that initializes the fields and creates some sample rooms
    public HotelManagementSystem() {
        rooms = new ArrayList<>();
        bookings = new ArrayList<>();
        // Create some sample rooms with different types and prices
        rooms.add(new Room( scanner.nextInt(),"Single", 100));
        rooms.add(new Room(scanner.nextInt(),"Double", 150));
        rooms.add(new Room(scanner.nextInt(),"Suite", 200));
    }
    // A method that displays the home page with the available functionality

    public void displayHomePage() {
        System.out.println("WELCOME TO OUR MOTEL COMFORT GROVE IN IBIZA !!!");
        System.out.println("1.Explore the room of the motel");
        System.out.println("2.Book a room");
        System.out.println("3.Display booked rooms");
        System.out.println("4.Display all available rooms");
        System.out.println("5.Exit the system");
        System.out.println("please chose an option from the following menu :");
        // Get the user's choice as an integer
        int choice = new Scanner(System.in).nextInt();
        // Call the corresponding method based on the choice
        switch(choice){
            case 1:
                exploreRooms();
                break;
            case 2:
                bookRoom();
                break;
            case 3:
                viewBookings();
                break;
            case 4:
                displayAvailableRooms();
                break;
            case 5:
                exitSystem();
                break;
            default :
                System.out.println("Invalid choice! Please try again.");
                displayHomePage();
                break;
        }
    }


    // A method that displays the details of each room in the motel
    public void exploreRooms() {
        System.out.println("Available rooms:");
        // Loop through the rooms list and print the details of each room
        for(Room room:rooms){
            if(room.isAvailable()){
                System.out.println("Room "+room.getRoomNumber());
            }}
        // Go back to the home page
        displayHomePage();
    }
    // A method that allows the user to book or register a room
    public void bookRoom() {
        System.out.println("Please enter the following information to book a room :");
        // Get the user's name, room number, check-in date and check-out date
        System.out.print("Enter a room number:");
        int roomNumber = scanner.nextInt();
        System.out.print("Enter guest name:");
        String name = scanner.next();
        System.out.print("Enter check-in date:");
        String checkInDate = scanner.next();
        System.out.print("Enter check-out date:");
        String checkOutDate = scanner.next();
        for(Room room:rooms) {
            if(room.getRoomNumber() == roomNumber && room.isAvailable()){
                room.setAvailable(false);
                bookings.add(new Booking( room, name, checkInDate, checkOutDate));
                System.out.println("Room "+ roomNumber + " is booked successfully for "+ name + " from "+ checkInDate + " to " + checkOutDate);
                return;
            }}
        System.out.println("Room " + roomNumber + " is not available.");
        // Go back to the home page
        displayHomePage();
    }

    // A method that displays the list of bookings made by customers
    public void viewBookings() {
        System.out.println("List of Bookings :");
        // Loop through the bookings list and print the details of each booking
        for(Booking booking:bookings){
            System.out.println("Guest :" + booking.getName() + ",Room :" + booking.getRoom().getRoomNumber());
        }
        // Go back to the home page
        displayHomePage();
    }
    // A method that displays all the rooms that are available for booking
    public void displayAvailableRooms() {
        System.out.println("The following rooms are available for booking:");
        // Loop through the rooms list and print the details of each room that is available
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println(room);
            }
        }
        // Go back to the home page
        displayHomePage();
    }
    // A method that exits the system
    public void exitSystem() {
        System.out.println("Thank you for using the Hotel Management System. Goodbye!");
        // Close the scanner
        scanner.close();
        // Terminate the program
        System.exit(0);
    }

}





