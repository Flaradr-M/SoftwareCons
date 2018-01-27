package fr.unantes.software.construction.associations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created on 27/01/2018.
 *
 * @author sunye.
 */
class SimpleEventTest {

    Event evt1;

    @BeforeEach
    void setUp() {
        evt1 = new SimpleEvent(Integer.valueOf(1));
    }

    @Test
    void testId() {
        assertEquals(Integer.valueOf(1), evt1.getId());
    }

    @Test
    void testName() {
        String expected = "Alice";
        evt1.setName(new String(expected));

        assertEquals(expected, evt1.getName());
    }

    @Test
    void testLocation() {
        String expected = "Nantes";
        evt1.setLocation(new String(expected));

        assertEquals(expected, evt1.getLocation());
    }

    @Test
    void testValidCalendar() {
        assertFalse(evt1.calendar().valid());

        evt1.calendar().insert(new SimpleCalendar());
        assertTrue(evt1.calendar().valid());
    }

    @Test
    void testInsertCalendar() {
        Calendar cal = new SimpleCalendar();

        evt1.calendar().insert(cal);
        assertEquals(cal.events().getId(), evt1.getId());

    }

    @Test
    void testInsertRemoveCalendar() {
        Calendar cal = new SimpleCalendar();

        evt1.calendar().insert(cal);
        evt1.calendar().remove();

        assertFalse(cal.events().valid());

    }
}