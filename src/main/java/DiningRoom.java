public class DiningRoom extends Room{
    private final String name;

    public DiningRoom(String name, int capacity, double length, double width) {
        super(capacity, Room.calculateSize(length, width));
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
