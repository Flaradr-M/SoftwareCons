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
    void testEventsInsert() {
        Event evt1 = new SimpleEvent(Integer.valueOf(1));
        Event evt2 = new SimpleEvent(Integer.valueOf(2));
        Event evt3 = new SimpleEvent(Integer.valueOf(3));

        Stream<Event> stream = Stream.of(evt1, evt2, evt3);

        stream.forEach(each -> cal1.events().insert(each));

        assertTrue(stream.allMatch(each -> each.calendar().valid()));
    }

    @Test
    void testEventsInsertRemove() {
        Event evt1 = new SimpleEvent(Integer.valueOf(1));
        Event evt2 = new SimpleEvent(Integer.valueOf(2));
        Event evt3 = new SimpleEvent(Integer.valueOf(3));
        CalendarEventsCursor cursor = cal1.events();

        Stream<Event> stream = Stream.of(evt1, evt2, evt3);
        stream.forEach(each -> cursor.insert(each));
        while (cursor.valid()) {
            cursor.remove();
        }

        assertFalse(stream.anyMatch(each -> each.calendar().valid()));
    }

}