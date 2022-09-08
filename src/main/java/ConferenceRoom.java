public class ConferenceRoom extends Room {
    private final String name;

    public ConferenceRoom(String name, int capacity, double length, double width) {
        super(capacity, Room.calculateSize(length, width));
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
