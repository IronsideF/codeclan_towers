import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class HotelTest {
    Hotel myHotel;
    Bedroom myBedroom;
    ConferenceRoom myConferenceRoom;
    Guest myGuest;
    DiningRoom myDiningRoom;
    Bedroom secondBedroom;
    ArrayList<Guest> guestList = new ArrayList<>();
    @Before
    public void before(){
        myBedroom = new Bedroom(1, RoomType.SINGLE, 10);
        secondBedroom = new Bedroom(2, RoomType.DOUBLE, 20);
        myConferenceRoom = new ConferenceRoom("The Jon Z Room", 30, 10, 15);
        myDiningRoom = new DiningRoom("The Esgrid Memorial Dining Room", 4, 10, 10);
        ArrayList<Bedroom> testBedrooms = new ArrayList<>();
        testBedrooms.add(myBedroom);
        testBedrooms.add(secondBedroom);
        ArrayList<ConferenceRoom> testConRooms = new ArrayList<>();
        testConRooms.add(myConferenceRoom);
        ArrayList<DiningRoom> testDiningRooms = new ArrayList<>();
        testDiningRooms.add(myDiningRoom);
        myHotel = new Hotel(testBedrooms, testConRooms, testDiningRooms);
        myGuest = new Guest("Keith");
        guestList.add(myGuest);
    }
    @Test
    public void hasProperties(){
        assertEquals(2, myHotel.getBedroomCount());
        assertEquals(1, myHotel.getConferenceRoomCount());
    }
    @Test
    public void canCheckInGuest(){
        myHotel.checkInGuest(myBedroom, guestList);
        assertEquals(1, myBedroom.getGuestCount());
    }
    @Test
    public void wontOverfillRoom(){
        myHotel.checkInGuest(secondBedroom, guestList);
        myHotel.checkInGuest(secondBedroom, guestList);
        assertEquals(1, secondBedroom.getGuestCount());
    }
    @Test
    public void canCheckOutGuest(){
        myHotel.checkInGuest(myBedroom, guestList);
        myHotel.checkOutGuest(myBedroom, myGuest);
        assertEquals(0, myBedroom.getGuestCount());
    }
    @Test
    public void canBookRoom(){
        Booking myBooking = myHotel.bookRoom(myBedroom, 5);
        assertEquals(5, myBooking.getNightsBooked());
    }
    @Test
    public void canGetTotalBill(){
        Booking myBooking = myHotel.bookRoom(myBedroom, 5);
        assertEquals(50, myBooking.getTotalBill());
    }
    @Test
    public void hasHashmapDiningRooms(){
        assertEquals(myDiningRoom, myHotel.getDiningRoomByName("The Esgrid Memorial Dining Room"));
    }
    @Test
    public void canAddDiningRoom(){
        DiningRoom newDiningRoom = new DiningRoom("The Basement", 2, 10, 10);
        myHotel.addDiningRoom(newDiningRoom);
        assertEquals(newDiningRoom, myHotel.getDiningRoomByName("The Basement"));
    }
    @Test
    public void roomsHaveSize(){
        assertEquals(50.0, myBedroom.getSize(), 0.0);
        assertEquals(150.0, myConferenceRoom.getSize(), 0.0);
        assertEquals(100.0, myDiningRoom.getSize(), 0.0);
    }
    @Test
    public void canGetVacantRooms(){
        myHotel.checkInGuest(myBedroom, guestList);
        assertEquals(1, myHotel.getVacantBedrooms().size());
    }
    @Test
    public void canFindGuestRoomByName(){
        myHotel.checkInGuest(myBedroom, guestList);
        assertEquals(myBedroom, myHotel.findGuestRoom("Keith"));
    }
    @Test
    public void willNotFindGuestNotInHotel(){
        assertNull(myHotel.findGuestRoom("Jon"));
    }


}
