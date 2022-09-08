public class Booking {
    private final Bedroom room;
    private final int nightsBooked;

    public Booking(Bedroom room, int nightsBooked) {
        this.room = room;
        this.nightsBooked = nightsBooked;
    }

    public Bedroom getRoom() {
        return room;
    }

    public int getNightsBooked() {
        return nightsBooked;
    }
    public int getTotalBill(){
        return this.room.getNightlyRate()*nightsBooked;
    }
}
