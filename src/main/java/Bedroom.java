public class Bedroom extends Room{

    private final int roomNumber;
    private final RoomType roomType;
    private final int nightlyRate;


    public Bedroom(int roomNumber, RoomType roomType, int nightlyRate) {
        super(roomType.getCapacity(), Room.calculateSize(roomType.getLength(), roomType.getWidth()));
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.nightlyRate = nightlyRate;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public int getNightlyRate() {
        return nightlyRate;
    }
}
