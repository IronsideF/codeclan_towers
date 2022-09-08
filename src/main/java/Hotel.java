import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Hotel {
    private final ArrayList<Bedroom> bedrooms;
    private final ArrayList<ConferenceRoom> conferenceRooms;
    private final HashMap<String, DiningRoom> diningRooms;

    public Hotel(ArrayList<Bedroom> bedrooms, ArrayList<ConferenceRoom> conferenceRooms, ArrayList<DiningRoom> diningRooms) {
        this.bedrooms = bedrooms;
        this.conferenceRooms = conferenceRooms;
        this.diningRooms = buildDiningRoomHashMap(diningRooms);
    }

    public int getBedroomCount(){
        return this.bedrooms.size();
    }
    public int getConferenceRoomCount(){
        return this.conferenceRooms.size();
    }
    public void checkInGuest(Room room, ArrayList<Guest> guests){
        room.checkIn(guests);
    }
    public void checkOutGuest(Room room, Guest guest){
        room.checkOut(guest);
    }
    public Booking bookRoom(Bedroom room, int nightsBooked){
        return new Booking(room, nightsBooked);
    }
    private HashMap<String, DiningRoom> buildDiningRoomHashMap(ArrayList<DiningRoom> diningRooms){
        HashMap<String, DiningRoom> result = new HashMap<>();
        for (DiningRoom room : diningRooms){
            result.put(room.getName(), room);
        }
        return result;
    }
    public void addDiningRoom(DiningRoom room){
        this.diningRooms.put(room.getName(), room);
    }
    public DiningRoom getDiningRoomByName(String name){
       return this.diningRooms.get(name);
    }
    public ArrayList<Bedroom> getVacantBedrooms(){
        ArrayList<Bedroom> result = new ArrayList<>();
        for (Bedroom room : this.bedrooms){
            if (room.getGuestCount()==0){
                result.add(room);
            }
        }
        return result;
    }
    public Room findGuestRoom(String name){
        for (Bedroom room: this.bedrooms){
            if (room.findGuestByName(name)){
                return room;
            }
        }
        return null;
    }


}
