import java.util.ArrayList;

public abstract class Room {

    private final int capacity;
    private final ArrayList<Guest> guests;
    private final double size;

    public Room(int capacity, double size) {
        this.capacity = capacity;
        this.guests = new ArrayList<>();
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getSize() {
        return size;
    }

    public int getGuestCount() {
        return guests.size();
    }
    public void checkIn(ArrayList<Guest> guests){
        if (getGuestCount()==0&&capacity>=guests.size()){
        this.guests.addAll(guests);
        }
    }
    public void checkOut(Guest guest){
        this.guests.remove(guest);
    }
    protected static double calculateSize(double length,double width){
        return length*width;
    }
    public Boolean findGuestByName(String name){
        for (Guest guest: this.guests){
            if (guest.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
}
