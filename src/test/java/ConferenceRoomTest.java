import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest{
        ConferenceRoom myConferenceRoom;
        @Before
        public void before(){
                myConferenceRoom = new ConferenceRoom("The Jon Z Room", 30, 10, 15);
        }
        @Test
        public void hasProperties(){
                assertEquals("The Jon Z Room", myConferenceRoom.getName());
                assertEquals(30, myConferenceRoom.getCapacity());
                assertEquals(0, myConferenceRoom.getGuestCount());
        }
}
