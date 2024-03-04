package JavaOOP;
class Hotel {
    String name = "Comfort Grove";
    int no_rooms = 15;
    Room[] rooms;

    public Hotel() {

        rooms = new Room[no_rooms];
        for (int i = 0; i < no_rooms; i++) {
            rooms[i] = new Room(i,"Single",100);
        }
    }

    public boolean bookRooms(String roomType, int quantity, double price) {
        int bookedRooms = 0;
        for (Room room : rooms) {
            if (room.getType().equals(roomType) && room.isAvailable()) {
                room.setAvailable(false);
                room.setPrice(price);
                bookedRooms++;
                if (bookedRooms == quantity) {
                    return true;
                }
            }
        }
        return false;
    }


}
