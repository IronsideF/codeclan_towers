import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BedroomTest {
    Bedroom myBedroom;

    @Before
    public void before(){
        myBedroom = new Bedroom(1, RoomType.SINGLE, 10);
    }
    @Test
    public void hasProperties(){
        assertEquals(1, myBedroom.getRoomNumber());
        assertEquals(RoomType.SINGLE, myBedroom.getRoomType());
        assertEquals(1, myBedroom.getCapacity());
        assertEquals(0, myBedroom.getGuestCount());
    }
}
