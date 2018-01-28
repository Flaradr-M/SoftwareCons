package fr.unantes.software.construction.associations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created on 27/01/2018.
 *
 * @author sunye.
 */
class SimpleCalendarTest {

    private Calendar cal1;

    @BeforeEach
    void setUp() {
        cal1 = new SimpleCalendar();
    }

    @Test
    void testName() {
        String expected = "##@##";
        cal1.setName(new String(expected));

        assertEquals(expected, cal1.getName());
    }

    @Test
    void testDescription() {
        String expected = "##@##";
        cal1.setDescription(new String(expected));

        assertEquals(expected, cal1.getDescription());
    }

    @Test
    void testBidirectionalAdd() {
        Event[] events = {new SimpleEvent(Integer.valueOf(1)), new SimpleEvent(Integer.valueOf(2)),
                new SimpleEvent(Integer.valueOf(3)), new SimpleEvent(Integer.valueOf(4))};

        for(Event each : events) {
            cal1.events().add(each);
        }

        for(Event each : events) {
            assertTrue(cal1.events().contains(each));
            assertEquals(cal1, each.calendar().get());
        }
    }

    @Test
    void testCompleteHandshake() {
        Calendar cal2 = new SimpleCalendar();

        Event[] events = {new SimpleEvent(Integer.valueOf(1)), new SimpleEvent(Integer.valueOf(2)),
                new SimpleEvent(Integer.valueOf(3)), new SimpleEvent(Integer.valueOf(4))};

        for(Event each : events) {
            cal1.events().add(each);
        }

        for(Event each : events) {
            cal2.events().add(each);
        }

        for(Event each : events) {
            assertFalse(cal1.events().contains(each));
            assertEquals(cal2, each.calendar().get());
        }
    }

    @Test
    void testRemove() {
        Event[] events = {new SimpleEvent(Integer.valueOf(1)), new SimpleEvent(Integer.valueOf(2)),
                new SimpleEvent(Integer.valueOf(3)), new SimpleEvent(Integer.valueOf(4))};

        for(Event each : events) {
            cal1.events().add(each);
        }

        assertEquals(events.length, cal1.events().size());

        for(Event each : events) {
            cal1.events().remove(each);
        }

        for(Event each : events) {
            assertFalse(each.calendar().isSet());
        }

        assertEquals(0, cal1.events().size());
    }
}