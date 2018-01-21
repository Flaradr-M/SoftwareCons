package fr.unantes.software.construction.attributes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;


/**
 * Created on 21/01/2018.
 *
 * @author NaoMod team.
 */
class SimpleEventTest {

    private Calendar start = Calendar.getInstance();
    private Calendar end = Calendar.getInstance();


    @BeforeEach
    void setup() {
        start.set(2018, 1, 21);
        end.set(2018, 1, 22);
    }

    @Test
    void testConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {new SimpleEvent(12, "Lab", end, start);});
    }

    @Test
    void getId() {
        Event evt = new SimpleEvent(12, "Lab", start, end);
        assertTrue(evt.getId() == 12);
    }

    @Test
    void getName() {
        Event evt = new SimpleEvent(12, "Lab", start, end);
        assertEquals(evt.getName(), "Lab");
    }

    @Test
    void setName() {
        Event evt = new SimpleEvent(12, "Lab", start, end);
        evt.setName("Other");
        assertEquals(evt.getName(), "Other");
    }

    @Test
    void testLocation() {
        Event evt = new SimpleEvent(12, "Lab", start, end);
        evt.setLocation("Nantes");
        assertEquals(evt.getLocation(), "Nantes");
    }

    @Test
    void testAlarm() {
        Event evt = new SimpleEvent(12, "Lab", start, end);
        evt.addAlarm(new Integer(42));
        evt.addAlarm(new Integer(13));
        evt.addAlarm(new Integer(99));

        assertEquals(evt.getAlarm(0), new Integer(42));
        assertEquals(evt.getAlarm(1), new Integer(13));
        assertEquals(evt.getAlarm(2), new Integer(99));
    }

    @Test
    void testAlarmExceeding() {
        Event evt = new SimpleEvent(12, "Lab", start, end);
        for (int i = 0; i < 5; i++) {
            evt.addAlarm(new Integer(i));
        }

        assertFalse(evt.addAlarm(new Integer(42)));
    }


    @Test
    void removeAlarm() {
        Event evt = new SimpleEvent(12, "Lab", start, end);
        evt.addAlarm(new Integer(42));
        evt.addAlarm(new Integer(13));
        evt.addAlarm(new Integer(99));

        evt.removeAlarm(1);

        assertEquals(evt.getAlarm(1), new Integer(99));
    }
}