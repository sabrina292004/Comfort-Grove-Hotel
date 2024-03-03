package JavaOOP;

public class Room {
        private final int roomNumber;
        private final String type;
        private final double price;
        private boolean available;
        public Room(int roomNumber,String type, double price) {
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



        @Override
        public String toString() {
            return "Room{" +
                    "type='" + type + '\'' +
                    ", price=" + price +" $ per night" +
                    ", availability=" + available +
                    '}';
        }

    }



