import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuestTest {

    Guest myGuest;

    @Before
    public void before(){
        myGuest = new Guest("Keith");
    }

    @Test
    public void hasName(){
        assertEquals("Keith", myGuest.getName());
    }
}
