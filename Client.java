
package JavaOOP;
import java.util.ArrayList;
import java.util.Scanner;
public class Client {
    


    String name;
    int roomNumber;
    String checkInDate;
    String checkOutDate;
    Room room;
    private static ArrayList<Room> BookedROOMS ;
    public ArrayList<Client> bookings ;

    public Client() {}

    public Client(String name, String checkInDate, String checkOutDate, Room room) {
        this.name = name;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.room = room;
    }
    public void bookRoom() {
        Scanner scanner=new Scanner (System.in);
        System.out.println("Please enter the following information to book a room :");
        // Get the user's name, room number, check-in date and check-out date
        System.out.print("Enter a room number:");
        this.roomNumber  = scanner.nextInt();

        System.out.print("Enter guest name:");
        this.name = scanner.next();
        int finaldate = checkdate();
        boolean is_booked=false;
        for (Room room : Room.getAllRooms()) {
            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                room.setAvailable(false);
               // BookedROOMS.add(Room.allRooms.get(roomNumber));
                System.out.println("Room "+ roomNumber+ " is booked successfully for "+ name + " for "+ finaldate + " nights");
                is_booked=true;
                break;
            }
        }
        if (!is_booked){System.out.println("Room " + roomNumber + " is not available.");}
    }
    public static ArrayList<Room> BookedRooms() {
        return BookedROOMS;
    }

    public int checkdate() {
        int[] months0 = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        int year1;
        String month1;
        int day1;
        int year2;
        String month2;
        int day2;
        int nights = 0;
        do {
            System.out.println("Please enter the date of your arrival:");
            year1 = Year(2025, true);
            month1 = Month(months);
            day1 = Day(months, months0, month1, year1);
            System.out.println("\nPlease enter the date of your departure:");
            do {
                    year2 = Year(3000, false);
                    if (year2 >= year1) {
                        break;
                    }
                    System.out.println("Departure year doesn't match with arrival year");
                }
            while (true);
            month2 = Month(months);
            day2 = Day(months, months0, month2, year2);

            for (int i = year1; i < year2; i++) {
                if (LeapYear(i)) {
                    nights += 366;
                } else {
                    nights += 365;
                }
            }

            for (int i = MonthIndex(months, month1); i >= 0; i--) {
                if (LeapYear(year1) && i == 1) {
                    nights -= 1;
                }
                nights -= months0[i];
            }

            for (int i = MonthIndex(months, month2); i >= 0; i--) {
                if (LeapYear(year1) && i == 1) {
                    nights += 1;
                }
                nights += months0[i];
            }

            nights -= day1;
            nights += day2;

            if (nights > 0) {
                break;
            }
            System.out.println("Invalid dates.\nPlease make sure you haven't switched the dates.");
        } 
        while (true);
        return nights;
        }
        public static int Year(int limit, boolean advance){
            Scanner S = new Scanner(System.in);
            int year;
            while(true) {
                System.out.print("Year:");
                year = S.nextInt();
                if(year>=2024 && year<=limit){
                    break;}
                else if(year>2025 && advance){
                    System.out.println("You can only book a year in advance");}
                else{
                    System.out.println("Year already passed or invalid");}}
            return year;}

        public static String Month(String[] months){
            Scanner S = new Scanner(System.in);
            String month;
            while(true){
                System.out.println("(Please only write the 3 first letters of the month!)");
                System.out.print("Month:");
                month = S.next();
                if (MonthChecker(months,month)){
                    break;}
                System.out.println("Invalid month");}
            return month;}

        public static int Day(String[] months, int[] months0, String month, int year) {
            Scanner S = new Scanner(System.in);
            int monthLimit =months0[MonthIndex(months, month)];
            if(LeapYear(year) && months[1].equalsIgnoreCase("feb")){
                monthLimit++;
            }
            int day;
            while (true) {
                System.out.print("Day:");
                day = S.nextInt();
                if (day > 0 && day <= monthLimit) {
                    break;
                }
                System.out.println("Invalid day");}
            return day;
        }
        public static boolean MonthChecker(String[] months,String month){
            boolean flag = false;
            for(String i: months){
                if (month.equalsIgnoreCase(i)){
                    flag = true;
                    break;}}
            return flag;}

        public static int MonthIndex(String[] strings, String month){
            int monthNumber=0;
            for(int i = 0;i<12;i++){
                if(month.equalsIgnoreCase(strings[i])){
                    monthNumber=i;
                    break;
                }}

            return monthNumber;}

        public static boolean LeapYear(int year){
            return ((year%4==0 && year%100!=0) || (year%100==0 && year%400==0));
        }



        
        public String userInfo() {
            return "Clients{" + "name=" + name + ", roomNumber=" + roomNumber + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + ", room=" + room + '}';
        }
}