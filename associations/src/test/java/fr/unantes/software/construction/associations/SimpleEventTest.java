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
    void testAlarm() {
        Event evt = new SimpleEvent(12);
        evt.addAlarm(Integer.valueOf(42));
        evt.addAlarm(Integer.valueOf(13));
        evt.addAlarm(Integer.valueOf(99));

        assertEquals(evt.getAlarm(0), Integer.valueOf(42));
        assertEquals(evt.getAlarm(1), Integer.valueOf(13));
        assertEquals(evt.getAlarm(2), Integer.valueOf(99));
    }

    @Test
    void testAlarmExceeding() {
        Event evt = new SimpleEvent(12);
        for (int i = 0; i < 5; i++) {
            evt.addAlarm(Integer.valueOf(i));
        }

        assertFalse(evt.addAlarm(Integer.valueOf(42)));
    }


    @Test
    void removeAlarm() {
        Event evt = new SimpleEvent(12);
        evt.addAlarm(Integer.valueOf(42));
        evt.addAlarm(Integer.valueOf(13));
        evt.addAlarm(Integer.valueOf(99));

        evt.removeAlarm(1);

        assertEquals(evt.getAlarm(1), Integer.valueOf(99));
    }

    @Test
    void testAddContacts() {
        Contact[] contacts = {new SimpleContact(), new SimpleContact(),
                new SimpleContact(),new SimpleContact()};

        for (Contact each: contacts) {
            evt1.invitees().add(each);
        }

        for (Contact each: contacts) {
            assertTrue(evt1.invitees().contains(each));
        }

        for (Contact each: contacts) {
            evt1.invitees().remove(each);
        }

        assertTrue(evt1.invitees().size() == 0);
    }

    @Test
    void testSetTask() {
        Task task1 = new SimpleTask();

        evt1.task().set(task1);

        assertEquals(evt1, task1.event().get());
    }

    @Test
    void testTaskCompleteHandshake() {
        Event evt2 = new SimpleEvent(Integer.valueOf(2));
        Task task1 = new SimpleTask();
        Task task2 = new SimpleTask();

        evt1.task().set(task1);
        evt2.task().set(task2);

        evt1.task().set(task2);

        assertFalse(task1.event().isSet());
        assertFalse(evt2.task().isSet());
        assertEquals(evt1, task2.event().get());
    }

    @Test
    void testSetCalendar() {
        Calendar cal1 = new SimpleCalendar();
        Calendar cal2 = new SimpleCalendar();

        evt1.calendar().set(cal1);
        assertTrue(cal1.events().contains(evt1));

        evt1.calendar().set(cal2);
        assertFalse(cal1.events().contains(evt1));
        assertTrue(cal2.events().contains(evt1));
        assertEquals(cal2, evt1.calendar().get());
    }
}