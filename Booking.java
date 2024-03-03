package JavaOOP;

public class Booking {
    private final Room roomNumber;
    private final String name;
    private final String checkInDate;
    private final String checkOutDate;
public Booking(Room roomNumber, String name, String checkInDate, String checkOutDate){
    this.roomNumber = roomNumber;
    this.name = name;
    this.checkInDate = checkInDate;
    this.checkOutDate = checkOutDate;
}

    public Room getRoom() {
        return roomNumber;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Booking{" +
                "room=" + roomNumber +
                ", name='" + name + '\'' +
                ", checkInDate='" + checkInDate + '\'' +
                ", checkOutDate='" + checkOutDate + '\'' +
                '}';
    }
}
