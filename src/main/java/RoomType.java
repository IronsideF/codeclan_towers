public enum RoomType {
    SINGLE(1, 5.0, 10.0),
    DOUBLE(2, 10.0, 20.0),
    TWIN(2, 10.0, 20.0),
    FAMILY(4, 40.0, 80.0);

    private final int capacity;
    private final double length;
    private final double width;

    RoomType(int capacity, double length, double width) {
        this.capacity = capacity;
        this.length = length;
        this.width = width;
    }
    public int getCapacity() {
        return capacity;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }
}
